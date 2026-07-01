package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$4 implements SpecialEffectsControllerFactory {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$4(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    @Override // androidx.fragment.app.SpecialEffectsControllerFactory
    @NonNull
    public SpecialEffectsController createController(@NonNull ViewGroup viewGroup) {
        return new DefaultSpecialEffectsController(viewGroup);
    }
}
