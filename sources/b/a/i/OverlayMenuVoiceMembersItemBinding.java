package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.VoiceUserView;

/* JADX INFO: renamed from: b.a.i.z0, reason: use source file name */
/* JADX INFO: compiled from: OverlayMenuVoiceMembersItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayMenuVoiceMembersItemBinding implements ViewBinding {

    @NonNull
    public final VoiceUserView a;

    public OverlayMenuVoiceMembersItemBinding(@NonNull VoiceUserView voiceUserView) {
        this.a = voiceUserView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
