package ds.generated.interpreter;

import org.spoofax.interpreter.terms.*;
import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.github.krukow.clj_lang.*;
import ds.manual.interpreter.*;
import org.metaborg.meta.interpreter.framework.*;

public class NoArgSeq_0 extends A_ArgSeq 
{ 
  public NoArgSeq_0 (SourceSection src) 
  { 
    super(src);
  }

  @Override public boolean equals(Object obj)
  { 
    if(this == obj)
    { 
      return true;
    }
    if(obj == null)
    { 
      return false;
    }
    if(getClass() != obj.getClass())
    { 
      return false;
    }
    final NoArgSeq_0 other = (NoArgSeq_0)obj;
    return true;
  }

  public R_default_VSeq execute_default(VirtualFrame frame, A_C _1, com.github.krukow.clj_ds.PersistentMap<String, A_V> _2)
  { 
    R_default_VSeq res;
    res = execute_default_1(frame, _1, _2);
    if(res != null)
    { 
      return res;
    }
    return super.execute_default(frame, _1, _2);
  }

  private R_default_VSeq execute_default_1(VirtualFrame frame, A_C _1, com.github.krukow.clj_ds.PersistentMap<String, A_V> _2)
  { 
    final A_C c_13404 = _1;
    final com.github.krukow.clj_ds.PersistentMap<String, A_V> l_string_v_13286 = _2;
    final NoVSeq_0 lifted_859700 = new NoVSeq_0(this.getSourceSection());
    return new R_default_VSeq(lifted_859700, l_string_v_13286);
  }

  @Override public IStrategoTerm toStrategoTerm(ITermFactory factory)
  { 
    IStrategoAppl term = factory.makeAppl(factory.makeConstructor("NoArgSeq", 0));
    return term;
  }
}