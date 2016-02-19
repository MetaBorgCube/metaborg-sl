package org.metaborg.lang.sl.interpreter.natives;

import java.util.Arrays;

import metaborg.meta.lang.dynsem.interpreter.terms.BuiltinTypesGen;
import metaborg.meta.lang.dynsem.interpreter.terms.IConTerm;

import org.metaborg.lang.sl.interpreter.generated.terms.NullV_0_Term;
import org.metaborg.meta.lang.dynsem.interpreter.DynSemContext;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.rules.Rule;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.rules.RuleResult;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.source.SourceSection;

public class rule_onReturn_1 extends Rule {

	public rule_onReturn_1() {
		super(SourceSection.createUnavailable("Rule", "onReturn"),
				FrameDescriptor.create());
		Truffle.getRuntime().createCallTarget(this);
	}

	@Override
	public int getArity() {
		return 1;
	}

	@Override
	public String getConstructor() {
		return "onReturn";
	}

	@Override
	public String getName() {
		return "default";
	}

	@Override
	public RuleResult execute(VirtualFrame frame) {
		Object[] arguments = frame.getArguments();
		IConTerm stmt = BuiltinTypesGen.asIConTerm(arguments[1]);

		DynSemContext context = DynSemContext.LANGUAGE
				.findContext0(DynSemContext.LANGUAGE.createFindContextNode0());

		Rule r = context.getRuleRegistry().lookupRule(getName(),
				stmt.constructor(), stmt.arity());

		Object[] args = Rule.buildArguments(stmt, stmt.allSubterms(),
				Arrays.copyOfRange(arguments, 2, arguments.length));

		RuleResult rr = null;
		try {
			CallTarget ct = r.getCallTarget();
			RuleResult rrSub = (RuleResult) ct.call(args);
			rr = new RuleResult();
			rr.result = new NullV_0_Term();
			rr.components = rrSub.components;
		} catch (ReturnException rex) {
			rr = rex.getResult();
		}
		return rr;
	}
}