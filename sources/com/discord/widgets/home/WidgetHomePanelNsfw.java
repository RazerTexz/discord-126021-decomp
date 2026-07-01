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
import b.a.d.AppHelpDesk;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.user.NsfwAllowance;
import com.discord.app.AppComponent;
import com.discord.databinding.WidgetHomePanelCenterNsfwBinding;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

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

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomePanelNsfw$toggleContainerVisibility$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            WidgetHomePanelNsfw.this.hidePanelSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomePanelNsfw$toggleContainerVisibility$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Function1 $onToggleNsfw;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function1 function1) {
            super(1);
            this.$onToggleNsfw = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetHomePanelNsfw.this.setContainerViewHidden(true, this.$onToggleNsfw);
        }
    }

    public WidgetHomePanelNsfw(AppComponent appComponent) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        this.appComponent = appComponent;
        this.guildsNsfwStore = StoreStream.INSTANCE.getGuildsNsfw();
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
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable.timer(HIDE_DE…S, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableD0, this.appComponent, null, 2, null), (Class<?>) WidgetHomePanelNsfw.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3(onToggleNsfw));
            return;
        }
        if (!this.stubInflated && stub != null && (viewInflate = stub.inflate()) != null) {
            this.stubInflated = true;
            int i = R.id.home_panel_center_nsfw_anchor_wrap;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.home_panel_center_nsfw_anchor_wrap);
            if (linearLayout != null) {
                i = R.id.home_panel_center_nsfw_art;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.home_panel_center_nsfw_art);
                if (imageView2 != null) {
                    i = R.id.home_panel_center_nsfw_confirm;
                    MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R.id.home_panel_center_nsfw_confirm);
                    if (materialButton3 != null) {
                        i = R.id.home_panel_center_nsfw_deny;
                        MaterialButton materialButton4 = (MaterialButton) viewInflate.findViewById(R.id.home_panel_center_nsfw_deny);
                        if (materialButton4 != null) {
                            i = R.id.home_panel_center_nsfw_description;
                            LinkifiedTextView linkifiedTextView3 = (LinkifiedTextView) viewInflate.findViewById(R.id.home_panel_center_nsfw_description);
                            if (linkifiedTextView3 != null) {
                                i = R.id.home_panel_center_nsfw_title;
                                TextView textView2 = (TextView) viewInflate.findViewById(R.id.home_panel_center_nsfw_title);
                                if (textView2 != null) {
                                    this.binding = new WidgetHomePanelCenterNsfwBinding((LinearLayout) viewInflate, linearLayout, imageView2, materialButton3, materialButton4, linkifiedTextView3, textView2);
                                    ViewCompat.setOnApplyWindowInsetsListener(viewInflate, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.home.WidgetHomePanelNsfw$toggleContainerVisibility$1$1
                                        @Override // androidx.core.view.OnApplyWindowInsetsListener
                                        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                                            Intrinsics3.checkNotNullParameter(view, "view");
                                            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
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
            if (widgetHomePanelCenterNsfwBinding != null && (materialButton2 = widgetHomePanelCenterNsfwBinding.c) != null) {
                ViewKt.setVisible(materialButton2, false);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding2 = this.binding;
            if (widgetHomePanelCenterNsfwBinding2 != null && (imageView = widgetHomePanelCenterNsfwBinding2.f2466b) != null) {
                imageView.setImageResource(R.drawable.img_age_gate_failure);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding3 = this.binding;
            if (widgetHomePanelCenterNsfwBinding3 != null && (materialButton = widgetHomePanelCenterNsfwBinding3.d) != null) {
                FormatUtils.m(materialButton, R.string.back, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding4 = this.binding;
            if (widgetHomePanelCenterNsfwBinding4 != null && (textView = widgetHomePanelCenterNsfwBinding4.f) != null) {
                FormatUtils.m(textView, R.string.age_gate_nsfw_underage_header, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
            }
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding5 = this.binding;
            if (widgetHomePanelCenterNsfwBinding5 != null && (linkifiedTextView2 = widgetHomePanelCenterNsfwBinding5.e) != null) {
                FormatUtils.m(linkifiedTextView2, R.string.age_gate_nsfw_underage_body, new Object[]{AppHelpDesk.a.a(115000084051L, "h_5206f3f2-0ee4-4380-b50a-25319e45bc7c")}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            }
        } else {
            WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding6 = this.binding;
            if (widgetHomePanelCenterNsfwBinding6 != null && (linkifiedTextView = widgetHomePanelCenterNsfwBinding6.e) != null) {
                FormatUtils.m(linkifiedTextView, R.string.age_gate_nsfw_description, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
            }
        }
        setContainerViewHidden(false, onToggleNsfw);
    }

    @MainThread
    public final void configureUI(final long guildId, boolean isChannelNsfw, boolean isNsfwUnconsented, NsfwAllowance nsfwAllowed, ViewStub viewStub, final Function1<? super Boolean, Unit> onToggleNsfw, final Function0<Unit> onDenyNsfw) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        Intrinsics3.checkNotNullParameter(onToggleNsfw, "onToggleNsfw");
        Subscription subscription = this.hidePanelSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        toggleContainerVisibility(isChannelNsfw, isNsfwUnconsented, nsfwAllowed, viewStub, onToggleNsfw);
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if (widgetHomePanelCenterNsfwBinding != null && (materialButton2 = widgetHomePanelCenterNsfwBinding.d) != null) {
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
        if (widgetHomePanelCenterNsfwBinding2 == null || (materialButton = widgetHomePanelCenterNsfwBinding2.c) == null) {
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
        Intrinsics3.checkNotNullParameter(insets, "insets");
        WidgetHomePanelCenterNsfwBinding widgetHomePanelCenterNsfwBinding = this.binding;
        if (widgetHomePanelCenterNsfwBinding == null || (linearLayout = widgetHomePanelCenterNsfwBinding.a) == null) {
            return;
        }
        ViewCompat.dispatchApplyWindowInsets(linearLayout, insets);
    }
}
