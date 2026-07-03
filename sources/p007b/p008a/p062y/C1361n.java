package p007b.p008a.p062y;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.discord.C5419R;
import com.discord.views.OverlayMenuBubbleDialog;
import com.discord.views.VoiceUserView;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.C1094z0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.y.n */
/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1361n extends AbstractC12240o implements Function2<LayoutInflater, ViewGroup, OverlayMenuBubbleDialog.C7081a> {

    /* JADX INFO: renamed from: j */
    public static final C1361n f2050j = new C1361n();

    public C1361n() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public OverlayMenuBubbleDialog.C7081a invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        ViewGroup viewGroup2 = viewGroup;
        C12238m.checkNotNullParameter(layoutInflater2, "layoutInflater");
        C12238m.checkNotNullParameter(viewGroup2, "parent");
        View viewInflate = layoutInflater2.inflate(C5419R.layout.overlay_menu_voice_members_item, viewGroup2, false);
        Objects.requireNonNull(viewInflate, "rootView");
        C1094z0 c1094z0 = new C1094z0((VoiceUserView) viewInflate);
        C12238m.checkNotNullExpressionValue(c1094z0, "OverlayMenuVoiceMembersI…tInflater, parent, false)");
        return new OverlayMenuBubbleDialog.C7081a(c1094z0);
    }
}
