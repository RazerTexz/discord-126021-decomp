package com.discord.widgets.home;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import b.a.d.f;
import b.a.k.b;
import com.discord.R$id;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppComponent;
import com.discord.databinding.WidgetHomePanelCenterNsfwBinding;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomePanelNsfw {
    private static final WidgetHomePanelNsfw$Companion Companion = new WidgetHomePanelNsfw$Companion(null);

    @Deprecated
    private static final long HIDE_DELAY_MILLIS = 500;
    private final AppComponent appComponent;
    private WidgetHomePanelCenterNsfwBinding binding;
    private final StoreGuildsNsfw guildsNsfwStore;
    private Subscription hidePanelSubscription;
    private boolean stubInflated;

    public WidgetHomePanelNsfw(AppComponent appComponent) {
        m.checkNotNullParameter(appComponent, "appComponent");
        this.appComponent = appComponent;
        this.guildsNsfwStore = StoreStream.Companion.getGuildsNsfw();
    }

    public static final /* synthetic */ StoreGuildsNsfw access$getGuildsNsfwStore$p(WidgetHomePanelNsfw widgetHomePanelNsfw) {
        return widgetHomePanelNsfw.guildsNsfwStore;
    }

    public static final /* synthetic */ Subscription access$getHidePanelSubscription$p(WidgetHomePanelNsfw widgetHomePanelNsfw) {
        return widgetHomePanelNsfw.hidePanelSubscription;
    }

    public static final /* synthetic */ void access$setContainerViewHidden(WidgetHomePanelNsfw widgetHomePanelNsfw, boolean z2, Function1 function1) {
        widgetHomePanelNsfw.setContainerViewHidden(z2, function1);
    }

    public static final /* synthetic */ void access$setHidePanelSubscription$p(WidgetHomePanelNsfw widgetHomePanelNsfw, Subscription subscription) {
        widgetHomePanelNsfw.hidePanelSubscription = subscription;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configureUI$default(WidgetHomePanelNsfw widgetHomePanelNsfw, long j, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, ViewStub viewStub, Function1 function1, Function0 function0, int i, Object obj) {
        widgetHomePanelNsfw.configureUI(j, z2, z3, nsfwAllowance, viewStub, function1, (i & 64) != 0 ? null : function0);
    }

    private final void setContainerViewHidden(boolean isHidden, Function1<? super Boolean, Unit> onToggleNsfw) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if ((widgetHomePanelCenterNsfwBinding == null || (linearLayout4 = widgetHomePanelCenterNsfwBinding.a) == null || linearLayout4.getVisibility() != 8) && isHidden) {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding2 = this.binding;
            if (widgetHomePanelCenterNsfwBinding2 != null && (linearLayout = widgetHomePanelCenterNsfwBinding2.a) != null) {
                linearLayout.setVisibility(8);
            }
            onToggleNsfw.invoke(Boolean.FALSE);
            return;
        }
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding3 = this.binding;
        if ((widgetHomePanelCenterNsfwBinding3 == null || (linearLayout3 = widgetHomePanelCenterNsfwBinding3.a) == null || linearLayout3.getVisibility() != 0) && !isHidden) {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding4 = this.binding;
            if (widgetHomePanelCenterNsfwBinding4 != null && (linearLayout2 = widgetHomePanelCenterNsfwBinding4.a) != null) {
                linearLayout2.setVisibility(0);
            }
            onToggleNsfw.invoke(Boolean.TRUE);
        }
    }

    private final void toggleContainerVisibility(boolean isChannelNsfw, boolean isNsfwUnconsented, NsfwAllowance nsfwAllowed, ViewStub stub, Function1<? super Boolean, Unit> onToggleNsfw) {
        LinkifiedTextView linkifiedTextView;
        LinkifiedTextView linkifiedTextView2;
        TextView textView;
        MaterialButton materialButton;
        ImageView imageView;
        MaterialButton materialButton2;
        View viewInflate;
        boolean z2 = nsfwAllowed == NsfwAllowance.DISALLOWED;
        if (!isChannelNsfw || (!isNsfwUnconsented && !z2)) {
            Observable<Long> observableD0 = Observable.d0(HIDE_DELAY_MILLIS, TimeUnit.MILLISECONDS);
            m.checkNotNullExpressionValue(observableD0, "Observable.timer(HIDE_DE…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this.appComponent, null, 2, null), WidgetHomePanelNsfw.class, (Context) null, new WidgetHomePanelNsfw$toggleContainerVisibility$2(this), (Function1) null, (Function0) null, (Function0) null, new WidgetHomePanelNsfw$toggleContainerVisibility$3(this, onToggleNsfw), 58, (Object) null);
            return;
        }
        if (!this.stubInflated && stub != null && (viewInflate = stub.inflate()) != null) {
            this.stubInflated = true;
            int i = R$id.home_panel_center_nsfw_anchor_wrap;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.home_panel_center_nsfw_anchor_wrap);
            if (linearLayout != null) {
                i = R$id.home_panel_center_nsfw_art;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R$id.home_panel_center_nsfw_art);
                if (imageView2 != null) {
                    i = R$id.home_panel_center_nsfw_confirm;
                    MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R$id.home_panel_center_nsfw_confirm);
                    if (materialButton3 != null) {
                        i = R$id.home_panel_center_nsfw_deny;
                        MaterialButton materialButton4 = (MaterialButton) viewInflate.findViewById(R$id.home_panel_center_nsfw_deny);
                        if (materialButton4 != null) {
                            i = R$id.home_panel_center_nsfw_description;
                            LinkifiedTextView linkifiedTextView3 = (LinkifiedTextView) viewInflate.findViewById(R$id.home_panel_center_nsfw_description);
                            if (linkifiedTextView3 != null) {
                                i = R$id.home_panel_center_nsfw_title;
                                TextView textView2 = (TextView) viewInflate.findViewById(R$id.home_panel_center_nsfw_title);
                                if (textView2 != null) {
                                    this.binding = new WidgetHomePanelCenterNsfwBinding((LinearLayout) viewInflate, linearLayout, imageView2, materialButton3, materialButton4, linkifiedTextView3, textView2);
                                    ViewCompat.setOnApplyWindowInsetsListener(viewInflate, WidgetHomePanelNsfw$toggleContainerVisibility$1$1.INSTANCE);
                                    viewInflate.requestApplyInsets();
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
        if (z2) {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
            if (widgetHomePanelCenterNsfwBinding != null && (materialButton2 = widgetHomePanelCenterNsfwBinding.c) != null) {
                ViewKt.setVisible(materialButton2, false);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding2 = this.binding;
            if (widgetHomePanelCenterNsfwBinding2 != null && (imageView = widgetHomePanelCenterNsfwBinding2.f2466b) != null) {
                imageView.setImageResource(2131232315);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding3 = this.binding;
            if (widgetHomePanelCenterNsfwBinding3 != null && (materialButton = widgetHomePanelCenterNsfwBinding3.d) != null) {
                b.n(materialButton, 2131886994, new Object[0], null, 4);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding4 = this.binding;
            if (widgetHomePanelCenterNsfwBinding4 != null && (textView = widgetHomePanelCenterNsfwBinding4.f) != null) {
                b.n(textView, 2131886394, new Object[0], null, 4);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding5 = this.binding;
            if (widgetHomePanelCenterNsfwBinding5 != null && (linkifiedTextView2 = widgetHomePanelCenterNsfwBinding5.e) != null) {
                b.n(linkifiedTextView2, 2131886393, new Object[]{f.a.a(115000084051L, "h_5206f3f2-0ee4-4380-b50a-25319e45bc7c")}, null, 4);
            }
        } else {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding6 = this.binding;
            if (widgetHomePanelCenterNsfwBinding6 != null && (linkifiedTextView = widgetHomePanelCenterNsfwBinding6.e) != null) {
                b.n(linkifiedTextView, 2131886392, new Object[0], null, 4);
            }
        }
        setContainerViewHidden(false, onToggleNsfw);
    }

    @MainThread
    public final void configureUI(long guildId, boolean isChannelNsfw, boolean isNsfwUnconsented, NsfwAllowance nsfwAllowed, ViewStub viewStub, Function1<? super Boolean, Unit> onToggleNsfw, Function0<Unit> onDenyNsfw) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        m.checkNotNullParameter(onToggleNsfw, "onToggleNsfw");
        Subscription subscription = this.hidePanelSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        toggleContainerVisibility(isChannelNsfw, isNsfwUnconsented, nsfwAllowed, viewStub, onToggleNsfw);
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if (widgetHomePanelCenterNsfwBinding != null && (materialButton2 = widgetHomePanelCenterNsfwBinding.d) != null) {
            materialButton2.setOnClickListener(new WidgetHomePanelNsfw$configureUI$1(this, guildId, onDenyNsfw));
        }
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding2 = this.binding;
        if (widgetHomePanelCenterNsfwBinding2 == null || (materialButton = widgetHomePanelCenterNsfwBinding2.c) == null) {
            return;
        }
        materialButton.setOnClickListener(new WidgetHomePanelNsfw$configureUI$2(this, guildId, onToggleNsfw));
    }

    public final void dispatchApplyWindowInsets(WindowInsetsCompat insets) {
        LinearLayout linearLayout;
        m.checkNotNullParameter(insets, "insets");
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if (widgetHomePanelCenterNsfwBinding == null || (linearLayout = widgetHomePanelCenterNsfwBinding.a) == null) {
            return;
        }
        ViewCompat.dispatchApplyWindowInsets(linearLayout, insets);
    }
}
