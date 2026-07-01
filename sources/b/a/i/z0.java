package b.a.i;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.VoiceUserView;

/* JADX INFO: compiled from: OverlayMenuVoiceMembersItemBinding.java */
/* JADX INFO: loaded from: classes.dex */
public final class z0 implements ViewBinding {

    @NonNull
    public final VoiceUserView a;

    public z0(@NonNull VoiceUserView voiceUserView) {
        this.a = voiceUserView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
