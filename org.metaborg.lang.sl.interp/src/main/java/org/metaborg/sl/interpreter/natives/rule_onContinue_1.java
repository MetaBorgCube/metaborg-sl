package org.metaborg.sl.interpreter.natives;

import org.metaborg.meta.lang.dynsem.interpreter.nodes.rules.Rule;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.rules.RuleKind;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.rules.RuleResult;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.rules.premises.reduction.DispatchNode;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.rules.premises.reduction.DispatchNodeGen;
import org.metaborg.sl.interpreter.generated.TypesGen;
import org.metaborg.sl.interpreter.generated.terms.IStmtTerm;
import org.metaborg.sl.interpreter.generated.terms.onContinue_1_Term;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.source.SourceSection;

public class rule_onContinue_1 extends Rule {

	@Child protected DispatchNode dispatchNode;

	public rule_onContinue_1() {
		super(SourceSection.createUnavailable("Rule", "onContinue"),
				new FrameDescriptor(), RuleKind.TERM, "default",
				onContinue_1_Term.class);
		this.dispatchNode = DispatchNodeGen.create(getSourceSection(),
				"default");
	}

	public RuleResult execute(VirtualFrame frame) {
		Object[] arguments = frame.getArguments();

		onContinue_1_Term reducedTerm = TypesGen
				.asonContinue_1_Term(arguments[0]);

		IStmtTerm stmt = reducedTerm.get_1();

		Object[] args = new Object[] { stmt, arguments[1], arguments[2] };

		return invoke(args);
	}

	private RuleResult invoke(Object[] args) {
		try {

			return (RuleResult) dispatchNode.execute(args[0].getClass(), args);
		} catch (ContinueException cex) {
			Object[] components = cex.getComponents();
			System.arraycopy(components, 0, args,
					args.length - components.length, components.length);
			// FIXME eliminate this recursive call
			return invoke(args);
		}
	}

}
