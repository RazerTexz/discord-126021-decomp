package p000;

import android.view.View;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.views.OverlayMenuView;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p062y.C1381s;
import p007b.p008a.p062y.C1384t;
import p658rx.Subscription;

/* JADX INFO: renamed from: f */
/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC12260f implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f25350j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f25351k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Object f25352l;

    public ViewOnClickListenerC12260f(int i, Object obj, Object obj2) {
        this.f25350j = i;
        this.f25351k = obj;
        this.f25352l = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f25350j;
        if (i != 0) {
            if (i != 1) {
                throw null;
            }
            OverlayMenuView overlayMenuView = (OverlayMenuView) this.f25351k;
            Long lValueOf = Long.valueOf(((OverlayMenuView.C7085a) this.f25352l).f19104c.getChannel().getId());
            int i2 = OverlayMenuView.f19098j;
            Objects.requireNonNull(overlayMenuView);
            overlayMenuView.getContext().startActivity(IntentUtils.RouteBuilders.INSTANCE.connectVoice(lValueOf != null ? lValueOf.longValue() : 0L).setClass(overlayMenuView.getContext(), AppActivity.Main.class).addFlags(268435456));
            overlayMenuView.onDismissRequested.invoke();
            return;
        }
        OverlayMenuView overlayMenuView2 = (OverlayMenuView) this.f25351k;
        Long lValueOf2 = Long.valueOf(((OverlayMenuView.C7085a) this.f25352l).f19104c.getChannel().getId());
        int i3 = OverlayMenuView.f19098j;
        Objects.requireNonNull(overlayMenuView2);
        if (lValueOf2 != null) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreInviteSettings.generateInvite$default(StoreStream.INSTANCE.getInviteSettings(), lValueOf2.longValue(), null, 2, null), overlayMenuView2, null, 2, null), (Class<?>) OverlayMenuView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C1381s(overlayMenuView2)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C1384t(overlayMenuView2));
        } else {
            C0876m.m169g(overlayMenuView2.getContext(), C5419R.string.instant_invite_failed_to_generate, 0, null, 12);
        }
    }
}
