package org.metaborg.lang.sl.interp;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.NullInputStream;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.metaborg.lang.sl.interpreter.generated.SLEntryPoint;
import org.metaborg.lang.sl.interpreter.generated.TypesGen;
import org.metaborg.lang.sl.interpreter.natives.ObjData;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.rules.RuleResult;

@RunWith(Parameterized.class)
public class TestSL {

	private TestData testData;
	private InputStream inputStream;
	private ByteArrayOutputStream outputStream;
	private ByteArrayOutputStream errorStream;

	public TestSL(TestData td) {
		this.testData = td;
	}

	@Before
	public void setUp() throws IOException {
		if (testData.inputFile != null) {
			InputStream is = new FileInputStream(new File(testData.inputFile));
			inputStream = is;
		} else {
			inputStream = new NullInputStream(0);
		}

		outputStream = new ByteArrayOutputStream();
		errorStream = new ByteArrayOutputStream();
	}

	@After
	public void tearDown() throws IOException {

		inputStream.close();
		outputStream.close();
		errorStream.close();
	}

	@Test
	public void testEagerEval() throws Exception {

		RuleResult res = SLEntryPoint.evaluateStatic(testData.programFile,
				inputStream, outputStream, errorStream);

		Object val = res.result;

		if (TypesGen.isIVTerm(val) && !TypesGen.isNullV_0_Term(val)) {
			outputStream.write((ObjData.v2s_1(TypesGen.asIVTerm(val)) + "\n")
					.getBytes());
		}

		outputStream.flush();
		errorStream.flush();

		String expectedOutput = IOUtils.toString(new FileInputStream(
				testData.outputFile));
		String actualOutput = new String(outputStream.toByteArray());

		if (errorStream.size() > 0) {
			actualOutput = new String(errorStream.toByteArray()) + "\n";
		}
		assertEquals(expectedOutput, actualOutput);
	}

	public static final String TESTSPATH = "src/test/resources/";

	@Parameters(name = "{index}: {0}")
	public static Collection<TestData[]> testTargets() {
		Collection<TestData[]> tests = new LinkedList<>();

		File testDir = new File("src/test/resources/");
		String[] programNames = testDir.list(new SLFileFilter());

		TestData[][] data = new TestData[programNames.length][];

		for (int i = 0; i < programNames.length; i++) {
			String programName = programNames[i];
			String baseName = FilenameUtils.getBaseName(programName);

			String expectedInput = TESTSPATH + baseName + ".input";
			if (!new File(expectedInput).exists()) {
				expectedInput = null;
			}

			String expectedOutput = TESTSPATH + baseName + ".output";
			if (!new File(expectedOutput).exists()) {
				expectedOutput = null;
			}

			data[i] = new TestData[] { new TestData(programName, TESTSPATH
					+ programName, expectedInput, expectedOutput) };
		}

		tests.addAll(Arrays.asList(data));

		return tests;
	}

	private static class TestData {
		public final String testname;
		public final String programFile;
		public final String inputFile;
		public final String outputFile;

		public TestData(String testname, String programFile, String inputFile,
				String outputFile) {
			this.testname = testname;
			this.programFile = programFile;
			this.inputFile = inputFile;
			this.outputFile = outputFile;
		}

		@Override
		public String toString() {
			return testname;
		}
	}

	private static class SLFileFilter implements FilenameFilter {

		@Override
		public boolean accept(File dir, String name) {
			return FilenameUtils.getExtension(name).equalsIgnoreCase("sl");
		}

	}
}
