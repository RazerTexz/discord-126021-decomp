package b.a.y;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.i.OverlayMenuVoiceMembersItemBinding;
import com.discord.R;
import com.discord.views.OverlayMenuBubbleDialog;
import com.discord.views.VoiceUserView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: b.a.y.n, reason: use source file name */
/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog2 extends Lambda implements Function2<LayoutInflater, ViewGroup, OverlayMenuBubbleDialog.a> {
    public static final OverlayMenuBubbleDialog2 j = new OverlayMenuBubbleDialog2();

    public OverlayMenuBubbleDialog2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public OverlayMenuBubbleDialog.a invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        Intrinsics3.checkNotNullParameter(layoutInflater2, "layoutInflater");
        Intrinsics3.checkNotNullParameter(viewGroup2, "parent");
        View viewInflate = layoutInflater2.inflate(R.layout.overlay_menu_voice_members_item, viewGroup2, false);
        Objects.requireNonNull(viewInflate, "rootView");
        OverlayMenuVoiceMembersItemBinding overlayMenuVoiceMembersItemBinding = new OverlayMenuVoiceMembersItemBinding((VoiceUserView) viewInflate);
        Intrinsics3.checkNotNullExpressionValue(overlayMenuVoiceMembersItemBinding, "OverlayMenuVoiceMembersI…tInflater, parent, false)");
        return new OverlayMenuBubbleDialog.a(overlayMenuVoiceMembersItemBinding);
    }
}
