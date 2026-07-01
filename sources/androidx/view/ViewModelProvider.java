package androidx.view;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelProvider {
    private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    private final ViewModelProvider$Factory mFactory;
    private final ViewModelStore mViewModelStore;

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner) {
        this(viewModelStoreOwner.getViewModelStore(), viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory() : ViewModelProvider$NewInstanceFactory.getInstance());
    }

    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @NonNull
    @MainThread
    public <T extends ViewModel> T get(@NonNull String str, @NonNull Class<T> cls) {
        T t;
        T t2 = (T) this.mViewModelStore.get(str);
        if (cls.isInstance(t2)) {
            Object obj = this.mFactory;
            if (obj instanceof ViewModelProvider$OnRequeryFactory) {
                ((ViewModelProvider$OnRequeryFactory) obj).onRequery(t2);
            }
            return t2;
        }
        ViewModelProvider$Factory viewModelProvider$Factory = this.mFactory;
        if (viewModelProvider$Factory instanceof ViewModelProvider$KeyedFactory) {
            t = (T) ((ViewModelProvider$KeyedFactory) viewModelProvider$Factory).create(str, cls);
        } else {
            t = (T) viewModelProvider$Factory.create(cls);
        }
        this.mViewModelStore.put(str, t);
        return t;
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner, @NonNull ViewModelProvider$Factory viewModelProvider$Factory) {
        this(viewModelStoreOwner.getViewModelStore(), viewModelProvider$Factory);
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull ViewModelProvider$Factory viewModelProvider$Factory) {
        this.mFactory = viewModelProvider$Factory;
        this.mViewModelStore = viewModelStore;
    }
}
