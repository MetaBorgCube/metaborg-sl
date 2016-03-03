package org.metaborg.lang.sl.desugar;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Fun$Def$Desug_3_0 extends Strategy 
{ 
  public static $Fun$Def$Desug_3_0 instance = new $Fun$Def$Desug_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy o_6, Strategy p_6, Strategy q_6)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("FunDefDesug_3_0");
    Fail54:
    { 
      IStrategoTerm p_74 = null;
      IStrategoTerm m_74 = null;
      IStrategoTerm n_74 = null;
      IStrategoTerm o_74 = null;
      IStrategoTerm q_74 = null;
      IStrategoTerm r_74 = null;
      if(term.getTermType() != IStrategoTerm.APPL || desugar._consFunDefDesug_3 != ((IStrategoAppl)term).getConstructor())
        break Fail54;
      m_74 = term.getSubterm(0);
      n_74 = term.getSubterm(1);
      o_74 = term.getSubterm(2);
      IStrategoList annos30 = term.getAnnotations();
      p_74 = annos30;
      term = o_6.invoke(context, m_74);
      if(term == null)
        break Fail54;
      q_74 = term;
      term = p_6.invoke(context, n_74);
      if(term == null)
        break Fail54;
      r_74 = term;
      term = q_6.invoke(context, o_74);
      if(term == null)
        break Fail54;
      term = termFactory.annotateTerm(termFactory.makeAppl(desugar._consFunDefDesug_3, new IStrategoTerm[]{q_74, r_74, term}), checkListAnnos(termFactory, p_74));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}