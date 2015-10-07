package ds.generated.interpreter;

import org.spoofax.interpreter.terms.*;
import com.oracle.truffle.api.frame.*;
import com.oracle.truffle.api.nodes.*;
import com.oracle.truffle.api.source.*;
import com.github.krukow.clj_lang.*;
import ds.manual.interpreter.*;
import org.metaborg.meta.interpreter.framework.*;

public class PropRead_2 extends A_Expr 
{ 
  @Child private A_Expr _1;

  @Child private A_ID _2;

  public PropRead_2 (SourceSection src, A_Expr _1, A_ID _2) 
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
    final PropRead_2 other = (PropRead_2)obj;
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
    final A_C c_13401 = _1;
    final com.github.krukow.clj_ds.PersistentMap<String, A_V> l_string_v_13282 = _2;
    final A_Expr lifted_858300 = this._1;
    final A_ID lifted_858400 = this._2;
    final R_default_V $tmp4724 = lifted_858300.execute_default(frame, c_13401, l_string_v_13282);
    final A_V lifted_86900 = $tmp4724.value;
    final com.github.krukow.clj_ds.PersistentMap<String, A_V> l_string_v_22422 = $tmp4724.get_1();
    final ObjV_1 $tmp4725 = lifted_86900.match(ObjV_1.class);
    if($tmp4725 != null)
    { 
      final ObjData od1590000 = $tmp4725.get_1();
      final __String2ID___1 $tmp4726 = lifted_858400.match(__String2ID___1.class);
      if($tmp4726 != null)
      { 
        final String prop1060000 = $tmp4726.get_1();
        final A_V lifted_858500 = od1590000.readProp(prop1060000);
        return new R_default_V(lifted_858500, l_string_v_22422);
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

  public A_ID get_2()
  { 
    return this._2;
  }

  @Override public IStrategoTerm toStrategoTerm(ITermFactory factory)
  { 
    IStrategoAppl term = factory.makeAppl(factory.makeConstructor("PropRead", 2), _1.toStrategoTerm(factory), _2.toStrategoTerm(factory));
    return term;
  }
}