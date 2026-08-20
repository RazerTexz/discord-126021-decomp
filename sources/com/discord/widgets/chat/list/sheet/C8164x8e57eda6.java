package com.discord.widgets.chat.list.sheet;

import android.text.style.StyleSpan;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.FontColorSpan;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1 */
/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8164x8e57eda6 extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $cmdColor;
    public final /* synthetic */ WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded $viewState;
    public final /* synthetic */ WidgetApplicationCommandBottomSheet this$0;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "it");
                User user = C8164x8e57eda6.this.$viewState.getUser();
                if (user != null) {
                    WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
                    long id2 = user.getId();
                    Long channelId = C8164x8e57eda6.this.$viewState.getChannelId();
                    FragmentManager childFragmentManager = C8164x8e57eda6.this.this$0.getChildFragmentManager();
                    C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    WidgetUserSheet.Companion.show$default(companion, id2, channelId, childFragmentManager, C8164x8e57eda6.this.$viewState.getGuildId(), null, null, null, 112, null);
                }
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            GuildMember interactionUser = C8164x8e57eda6.this.$viewState.getInteractionUser();
            if (interactionUser != null) {
                hook.styles.add(new FontColorSpan(interactionUser.getColor()));
            }
            hook.styles.add(new ClickableSpan(null, false, null, new AnonymousClass2(), 4, null));
            hook.styles.add(new StyleSpan(1));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8164x8e57eda6(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet, WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded loaded, int i) {
        super(1);
        this.this$0 = widgetApplicationCommandBottomSheet;
        this.$viewState = loaded;
        this.$cmdColor = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class AnonymousClass3 extends AbstractC12240o implements Function1<Hook, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8422a("usernameOnClick", new AnonymousClass1());
        renderContext.m8422a("commandName", new AnonymousClass2());
        renderContext.m8422a("applicationName", AnonymousClass3.INSTANCE);
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Hook, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new FontColorSpan(C8164x8e57eda6.this.$cmdColor));
            hook.styles.add(new StyleSpan(1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }
    }
}
