package b.a.y;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.i.z0;
import com.discord.R$layout;
import com.discord.views.OverlayMenuBubbleDialog$a;
import com.discord.views.VoiceUserView;
import java.util.Objects;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n extends d0.z.d.o implements Function2<LayoutInflater, ViewGroup, OverlayMenuBubbleDialog$a> {
    public static final n j = new n();

    public n() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public OverlayMenuBubbleDialog$a invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        d0.z.d.m.checkNotNullParameter(layoutInflater2, "layoutInflater");
        d0.z.d.m.checkNotNullParameter(viewGroup2, "parent");
        View viewInflate = layoutInflater2.inflate(R$layout.overlay_menu_voice_members_item, viewGroup2, false);
        Objects.requireNonNull(viewInflate, "rootView");
        z0 z0Var = new z0((VoiceUserView) viewInflate);
        d0.z.d.m.checkNotNullExpressionValue(z0Var, "OverlayMenuVoiceMembersI…tInflater, parent, false)");
        return new OverlayMenuBubbleDialog$a(z0Var);
    }
}
