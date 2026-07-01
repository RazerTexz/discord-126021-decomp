package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.stages.SpeakersRecyclerView;

/* JADX INFO: compiled from: ViewStageCardSpeakersBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class v3 implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SpeakersRecyclerView f217b;

    public v3(@NonNull View view, @NonNull SpeakersRecyclerView speakersRecyclerView) {
        this.a = view;
        this.f217b = speakersRecyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
