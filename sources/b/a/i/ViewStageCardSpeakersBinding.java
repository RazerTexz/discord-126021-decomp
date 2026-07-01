package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.stages.SpeakersAdapter2;

/* JADX INFO: renamed from: b.a.i.v3, reason: use source file name */
/* JADX INFO: compiled from: ViewStageCardSpeakersBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewStageCardSpeakersBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SpeakersAdapter2 f217b;

    public ViewStageCardSpeakersBinding(@NonNull View view, @NonNull SpeakersAdapter2 speakersAdapter2) {
        this.a = view;
        this.f217b = speakersAdapter2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
