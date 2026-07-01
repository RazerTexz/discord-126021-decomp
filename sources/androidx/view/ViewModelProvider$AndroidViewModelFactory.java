package androidx.view;

import android.app.Application;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public class ViewModelProvider$AndroidViewModelFactory extends ViewModelProvider$NewInstanceFactory {
    private static ViewModelProvider$AndroidViewModelFactory sInstance;
    private Application mApplication;

    public ViewModelProvider$AndroidViewModelFactory(@NonNull Application application) {
        this.mApplication = application;
    }

    @NonNull
    public static ViewModelProvider$AndroidViewModelFactory getInstance(@NonNull Application application) {
        if (sInstance == null) {
            sInstance = new ViewModelProvider$AndroidViewModelFactory(application);
        }
        return sInstance;
    }

    @Override // androidx.view.ViewModelProvider$NewInstanceFactory, androidx.view.ViewModelProvider$Factory
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> cls) {
        if (!AndroidViewModel.class.isAssignableFrom(cls)) {
            return (T) super.create(cls);
        }
        try {
            return cls.getConstructor(Application.class).newInstance(this.mApplication);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Cannot create an instance of " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Cannot create an instance of " + cls, e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("Cannot create an instance of " + cls, e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        }
    }
}
