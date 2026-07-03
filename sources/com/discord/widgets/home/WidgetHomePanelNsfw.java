package com.discord.widgets.home;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import com.discord.C5419R;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppComponent;
import com.discord.databinding.WidgetHomePanelCenterNsfwBinding;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomePanelNsfw {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final long HIDE_DELAY_MILLIS = 500;
    private final AppComponent appComponent;
    private WidgetHomePanelCenterNsfwBinding binding;
    private final StoreGuildsNsfw guildsNsfwStore;
    private Subscription hidePanelSubscription;
    private boolean stubInflated;

    /* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomePanelNsfw$toggleContainerVisibility$2 */
    /* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
    public static final class C89772 extends AbstractC12240o implements Function1<Subscription, Unit> {
        public C89772() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            C12238m.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetHomePanelNsfw.this.hidePanelSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomePanelNsfw$toggleContainerVisibility$3 */
    /* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
    public static final class C89783 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ Function1 $onToggleNsfw;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C89783(Function1 function1) {
            super(1);
            this.$onToggleNsfw = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetHomePanelNsfw.this.setContainerViewHidden(true, this.$onToggleNsfw);
        }
    }

    public WidgetHomePanelNsfw(AppComponent appComponent) {
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        this.appComponent = appComponent;
        this.guildsNsfwStore = StoreStream.INSTANCE.getGuildsNsfw();
    }

    private final void setContainerViewHidden(boolean isHidden, Function1<? super Boolean, Unit> onToggleNsfw) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if ((widgetHomePanelCenterNsfwBinding == null || (linearLayout4 = widgetHomePanelCenterNsfwBinding.f17132a) == null || linearLayout4.getVisibility() != 8) && isHidden) {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding2 = this.binding;
            if (widgetHomePanelCenterNsfwBinding2 != null && (linearLayout = widgetHomePanelCenterNsfwBinding2.f17132a) != null) {
                linearLayout.setVisibility(8);
            }
            onToggleNsfw.invoke(Boolean.FALSE);
            return;
        }
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding3 = this.binding;
        if ((widgetHomePanelCenterNsfwBinding3 == null || (linearLayout3 = widgetHomePanelCenterNsfwBinding3.f17132a) == null || linearLayout3.getVisibility() != 0) && !isHidden) {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding4 = this.binding;
            if (widgetHomePanelCenterNsfwBinding4 != null && (linearLayout2 = widgetHomePanelCenterNsfwBinding4.f17132a) != null) {
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
            Observable<Long> observableM11068d0 = Observable.m11068d0(HIDE_DELAY_MILLIS, TimeUnit.MILLISECONDS);
            C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable.timer(HIDE_DE…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this.appComponent, null, 2, null), (Class<?>) WidgetHomePanelNsfw.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C89772()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89783(onToggleNsfw));
            return;
        }
        if (!this.stubInflated && stub != null && (viewInflate = stub.inflate()) != null) {
            this.stubInflated = true;
            int i = C5419R.id.home_panel_center_nsfw_anchor_wrap;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.home_panel_center_nsfw_anchor_wrap);
            if (linearLayout != null) {
                i = C5419R.id.home_panel_center_nsfw_art;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(C5419R.id.home_panel_center_nsfw_art);
                if (imageView2 != null) {
                    i = C5419R.id.home_panel_center_nsfw_confirm;
                    MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(C5419R.id.home_panel_center_nsfw_confirm);
                    if (materialButton3 != null) {
                        i = C5419R.id.home_panel_center_nsfw_deny;
                        MaterialButton materialButton4 = (MaterialButton) viewInflate.findViewById(C5419R.id.home_panel_center_nsfw_deny);
                        if (materialButton4 != null) {
                            i = C5419R.id.home_panel_center_nsfw_description;
                            LinkifiedTextView linkifiedTextView3 = (LinkifiedTextView) viewInflate.findViewById(C5419R.id.home_panel_center_nsfw_description);
                            if (linkifiedTextView3 != null) {
                                i = C5419R.id.home_panel_center_nsfw_title;
                                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.home_panel_center_nsfw_title);
                                if (textView2 != null) {
                                    this.binding = new WidgetHomePanelCenterNsfwBinding((LinearLayout) viewInflate, linearLayout, imageView2, materialButton3, materialButton4, linkifiedTextView3, textView2);
                                    ViewCompat.setOnApplyWindowInsetsListener(viewInflate, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.home.WidgetHomePanelNsfw$toggleContainerVisibility$1$1
                                        @Override // androidx.core.view.OnApplyWindowInsetsListener
                                        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                                            C12238m.checkNotNullParameter(view, "view");
                                            C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                                            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                                            return windowInsetsCompat.consumeSystemWindowInsets();
                                        }
                                    });
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
            if (widgetHomePanelCenterNsfwBinding != null && (materialButton2 = widgetHomePanelCenterNsfwBinding.f17134c) != null) {
                ViewKt.setVisible(materialButton2, false);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding2 = this.binding;
            if (widgetHomePanelCenterNsfwBinding2 != null && (imageView = widgetHomePanelCenterNsfwBinding2.f17133b) != null) {
                imageView.setImageResource(C5419R.drawable.img_age_gate_failure);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding3 = this.binding;
            if (widgetHomePanelCenterNsfwBinding3 != null && (materialButton = widgetHomePanelCenterNsfwBinding3.f17135d) != null) {
                C1107b.m221m(materialButton, C5419R.string.back, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding4 = this.binding;
            if (widgetHomePanelCenterNsfwBinding4 != null && (textView = widgetHomePanelCenterNsfwBinding4.f17137f) != null) {
                C1107b.m221m(textView, C5419R.string.age_gate_nsfw_underage_header, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding5 = this.binding;
            if (widgetHomePanelCenterNsfwBinding5 != null && (linkifiedTextView2 = widgetHomePanelCenterNsfwBinding5.f17136e) != null) {
                C1107b.m221m(linkifiedTextView2, C5419R.string.age_gate_nsfw_underage_body, new Object[]{C0862f.f507a.m149a(115000084051L, "h_5206f3f2-0ee4-4380-b50a-25319e45bc7c")}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
            }
        } else {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding6 = this.binding;
            if (widgetHomePanelCenterNsfwBinding6 != null && (linkifiedTextView = widgetHomePanelCenterNsfwBinding6.f17136e) != null) {
                C1107b.m221m(linkifiedTextView, C5419R.string.age_gate_nsfw_description, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
            }
        }
        setContainerViewHidden(false, onToggleNsfw);
    }

    @MainThread
    public final void configureUI(final long guildId, boolean isChannelNsfw, boolean isNsfwUnconsented, NsfwAllowance nsfwAllowed, ViewStub viewStub, final Function1<? super Boolean, Unit> onToggleNsfw, final Function0<Unit> onDenyNsfw) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        C12238m.checkNotNullParameter(onToggleNsfw, "onToggleNsfw");
        Subscription subscription = this.hidePanelSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        toggleContainerVisibility(isChannelNsfw, isNsfwUnconsented, nsfwAllowed, viewStub, onToggleNsfw);
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if (widgetHomePanelCenterNsfwBinding != null && (materialButton2 = widgetHomePanelCenterNsfwBinding.f17135d) != null) {
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.home.WidgetHomePanelNsfw.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetHomePanelNsfw.this.guildsNsfwStore.deny(guildId);
                    Function0 function0 = onDenyNsfw;
                    if (function0 != null) {
                    }
                }
            });
        }
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding2 = this.binding;
        if (widgetHomePanelCenterNsfwBinding2 == null || (materialButton = widgetHomePanelCenterNsfwBinding2.f17134c) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.home.WidgetHomePanelNsfw.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHomePanelNsfw.this.guildsNsfwStore.allow(guildId);
                WidgetHomePanelNsfw.this.setContainerViewHidden(true, onToggleNsfw);
            }
        });
    }

    public final void dispatchApplyWindowInsets(WindowInsetsCompat insets) {
        LinearLayout linearLayout;
        C12238m.checkNotNullParameter(insets, "insets");
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if (widgetHomePanelCenterNsfwBinding == null || (linearLayout = widgetHomePanelCenterNsfwBinding.f17132a) == null) {
            return;
        }
        ViewCompat.dispatchApplyWindowInsets(linearLayout, insets);
    }
}
