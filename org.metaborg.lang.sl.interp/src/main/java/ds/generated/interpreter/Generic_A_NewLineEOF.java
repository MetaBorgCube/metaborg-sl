package ds.generated.interpreter;

import java.util.Objects;
import org.metaborg.meta.interpreter.framework.*;
import org.spoofax.interpreter.terms.*;
import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;

public class Generic_A_NewLineEOF extends A_NewLineEOF implements IGenericNode
{ 
  private IStrategoTerm aterm;

  public Generic_A_NewLineEOF (SourceSection src, IStrategoTerm term) 
  { 
    super(src);
    Objects.requireNonNull(term);
    this.aterm = term;
  }

  @Override public <T> T match(Class<T> clazz)
  { 
    return specialize().match(clazz);
  }

  @Override public A_NewLineEOF specialize()
  { 
    if(aterm instanceof IStrategoAppl)
    { 
      final IStrategoAppl term = (IStrategoAppl)aterm;
      final String name = term.getName();
      final SourceSection source = SourceSectionUtil.fromStrategoTerm(term);
      if(name.equals("__String2NewLineEOF__") && term.getSubtermCount() == 1)
      { 
        A_NewLineEOF replacement = replace(new __String2NewLineEOF___1(source, TermUtils.stringFromTerm(term.getSubterm(0))));
        return replacement;
      }
    }
    try
    { 
      return replace(new __String2NewLineEOF___1(this.getSourceSection(), TermUtils.stringFromTerm(aterm)));
    }
    catch(MalformedASTException l_344469)
    { }
    throw new MalformedASTException(aterm.toString());
  }

  @Override public IStrategoTerm toStrategoTerm(ITermFactory factory)
  { 
    return aterm;
  }
}