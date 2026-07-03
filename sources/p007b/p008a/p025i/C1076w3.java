package p007b.p008a.p025i;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.VoiceUserView;
import com.discord.views.calls.SpeakerPulseView;

/* JADX INFO: renamed from: b.a.i.w3 */
/* JADX INFO: compiled from: ViewStageChannelSpeakerBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1076w3 implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final View f1348a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final VoiceUserView f1349b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f1350c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ImageView f1351d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ImageView f1352e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final ImageView f1353f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f1354g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final SpeakerPulseView f1355h;

    public C1076w3(@NonNull View view, @NonNull VoiceUserView voiceUserView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull TextView textView, @NonNull SpeakerPulseView speakerPulseView) {
        this.f1348a = view;
        this.f1349b = voiceUserView;
        this.f1350c = imageView;
        this.f1351d = imageView2;
        this.f1352e = imageView3;
        this.f1353f = imageView4;
        this.f1354g = textView;
        this.f1355h = speakerPulseView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f1348a;
    }
}
