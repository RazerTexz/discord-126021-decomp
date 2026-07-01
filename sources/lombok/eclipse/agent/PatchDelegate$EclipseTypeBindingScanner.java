package lombok.eclipse.agent;

import org.eclipse.jdt.internal.compiler.lookup.ArrayBinding;
import org.eclipse.jdt.internal.compiler.lookup.BaseTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.eclipse.jdt.internal.compiler.lookup.ParameterizedTypeBinding;
import org.eclipse.jdt.internal.compiler.lookup.ReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.TypeVariableBinding;
import org.eclipse.jdt.internal.compiler.lookup.UnresolvedReferenceBinding;
import org.eclipse.jdt.internal.compiler.lookup.WildcardBinding;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchDelegate$EclipseTypeBindingScanner.SCL.lombok */
public abstract class PatchDelegate$EclipseTypeBindingScanner {
    public void visitRaw(Binding binding) {
        if (binding == null) {
            return;
        }
        if (binding instanceof MethodBinding) {
            visitMethod((MethodBinding) binding);
        }
        if (binding instanceof BaseTypeBinding) {
            visitBase((BaseTypeBinding) binding);
        }
        if (binding instanceof ArrayBinding) {
            visitArray((ArrayBinding) binding);
        }
        if (binding instanceof UnresolvedReferenceBinding) {
            visitUnresolved((UnresolvedReferenceBinding) binding);
        }
        if (binding instanceof WildcardBinding) {
            visitWildcard((WildcardBinding) binding);
        }
        if (binding instanceof TypeVariableBinding) {
            visitTypeVariable((TypeVariableBinding) binding);
        }
        if (binding instanceof ParameterizedTypeBinding) {
            visitParameterized((ParameterizedTypeBinding) binding);
        }
        if (binding instanceof ReferenceBinding) {
            visitReference((ReferenceBinding) binding);
        }
    }

    public void visitReference(ReferenceBinding binding) {
    }

    public void visitParameterized(ParameterizedTypeBinding binding) {
        visitRaw(binding.genericType());
        Binding[] bindingArrTypeVariables = binding.typeVariables();
        if (bindingArrTypeVariables != null) {
            for (Binding binding2 : bindingArrTypeVariables) {
                visitRaw(binding2);
            }
        }
    }

    public void visitTypeVariable(TypeVariableBinding binding) {
        visitRaw(binding.superclass);
        Binding[] bindingArrSuperInterfaces = binding.superInterfaces();
        if (bindingArrSuperInterfaces != null) {
            for (Binding binding2 : bindingArrSuperInterfaces) {
                visitRaw(binding2);
            }
        }
    }

    public void visitWildcard(WildcardBinding binding) {
        visitRaw(binding.bound);
    }

    public void visitUnresolved(UnresolvedReferenceBinding binding) {
    }

    public void visitArray(ArrayBinding binding) {
        visitRaw(binding.leafComponentType());
    }

    public void visitBase(BaseTypeBinding binding) {
    }

    public void visitMethod(MethodBinding binding) {
        if (binding.parameters != null) {
            for (Binding binding2 : binding.parameters) {
                visitRaw(binding2);
            }
        }
        visitRaw(binding.returnType);
        if (binding.thrownExceptions != null) {
            for (Binding binding3 : binding.thrownExceptions) {
                visitRaw(binding3);
            }
        }
        TypeVariableBinding[] typeVars = binding.typeVariables();
        if (typeVars != null) {
            for (TypeVariableBinding child : typeVars) {
                visitRaw(child.superclass);
                Binding[] bindingArrSuperInterfaces = child.superInterfaces();
                if (bindingArrSuperInterfaces != null) {
                    for (Binding binding4 : bindingArrSuperInterfaces) {
                        visitRaw(binding4);
                    }
                }
            }
        }
    }
}
