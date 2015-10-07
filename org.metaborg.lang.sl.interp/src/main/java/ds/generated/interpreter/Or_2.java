package ds.generated.interpreter;

import org.spoofax.interpreter.terms.*;
import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.github.krukow.clj_lang.*;
import ds.manual.interpreter.*;
import org.metaborg.meta.interpreter.framework.*;

public class Or_2 extends A_Expr 
{ 
  @Child private A_Expr _1;

  @Child private A_Expr _2;

  public Or_2 (SourceSection src, A_Expr _1, A_Expr _2) 
  { 
    super(src);
    this._1 = _1;
    this._2 = _2;
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
    final Or_2 other = (Or_2)obj;
    if(_1 == null)
    { 
      if(other._1 != null)
      { 
        return false;
      }
    }
    else
      if(!_1.equals(other._1))
      { 
        return false;
      }
    if(_2 == null)
    { 
      if(other._2 != null)
      { 
        return false;
      }
    }
    else
      if(!_2.equals(other._2))
      { 
        return false;
      }
    return true;
  }

  public R_default_V execute_default(VirtualFrame frame, A_C _1, com.github.krukow.clj_ds.PersistentMap<String, A_V> _2)
  { 
    R_default_V res;
    res = execute_default_1(frame, _1, _2);
    if(res != null)
    { 
      return res;
    }
    return super.execute_default(frame, _1, _2);
  }

  private R_default_V execute_default_1(VirtualFrame frame, A_C _1, com.github.krukow.clj_ds.PersistentMap<String, A_V> _2)
  { 
    final A_C c_13402 = _1;
    final com.github.krukow.clj_ds.PersistentMap<String, A_V> l_string_v_13283 = _2;
    final A_Expr lifted_858900 = this._1;
    final A_Expr lifted_859000 = this._2;
    final R_default_V $tmp4713 = lifted_858900.execute_default(frame, c_13402, l_string_v_13283);
    final A_V lifted_86920 = $tmp4713.value;
    final com.github.krukow.clj_ds.PersistentMap<String, A_V> l_string_v_22423 = $tmp4713.get_1();
    final BoolV_1 $tmp4714 = lifted_86920.match(BoolV_1.class);
    if($tmp4714 != null)
    { 
      final boolean b1810000 = $tmp4714.get_1();
      final R_default_V $tmp4715 = lifted_859000.execute_default(frame, c_13402, l_string_v_22423);
      final A_V lifted_86910 = $tmp4715.value;
      final com.github.krukow.clj_ds.PersistentMap<String, A_V> l_string_v_31738 = $tmp4715.get_1();
      final BoolV_1 $tmp4716 = lifted_86910.match(BoolV_1.class);
      if($tmp4716 != null)
      { 
        final boolean b2810000 = $tmp4716.get_1();
        final BoolV_1 lifted_859100 = new BoolV_1(this.getSourceSection(), ds.manual.interpreter.Natives.orB_2(b1810000, b2810000));
        return new R_default_V(lifted_859100, l_string_v_31738);
      }
      else
      { }
    }
    else
    { }
    return null;
  }

  public A_Expr get_1()
  { 
    return this._1;
  }

  public A_Expr get_2()
  { 
    return this._2;
  }

  @Override public IStrategoTerm toStrategoTerm(ITermFactory factory)
  { 
    IStrategoAppl term = factory.makeAppl(factory.makeConstructor("Or", 2), _1.toStrategoTerm(factory), _2.toStrategoTerm(factory));
    return term;
  }
}