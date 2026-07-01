package b.a.i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.VoiceUserView;
import com.discord.views.calls.SpeakerPulseView;

/* JADX INFO: renamed from: b.a.i.w3, reason: use source file name */
/* JADX INFO: compiled from: ViewStageChannelSpeakerBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class ViewStageChannelSpeakerBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final VoiceUserView f223b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final ImageView d;

    @NonNull
    public final ImageView e;

    @NonNull
    public final ImageView f;

    @NonNull
    public final TextView g;

    @NonNull
    public final SpeakerPulseView h;

    public ViewStageChannelSpeakerBinding(@NonNull View view, @NonNull VoiceUserView voiceUserView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull TextView textView, @NonNull SpeakerPulseView speakerPulseView) {
        this.a = view;
        this.f223b = voiceUserView;
        this.c = imageView;
        this.d = imageView2;
        this.e = imageView3;
        this.f = imageView4;
        this.g = textView;
        this.h = speakerPulseView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
