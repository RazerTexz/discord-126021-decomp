package p007b.p008a.p025i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.stages.SpeakersRecyclerView;

/* JADX INFO: renamed from: b.a.i.v3 */
/* JADX INFO: compiled from: ViewStageCardSpeakersBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1069v3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1318a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final SpeakersRecyclerView f1319b;

    public C1069v3(@NonNull View view, @NonNull SpeakersRecyclerView speakersRecyclerView) {
        this.f1318a = view;
        this.f1319b = speakersRecyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1318a;
    }
}
