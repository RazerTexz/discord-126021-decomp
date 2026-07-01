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
import com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheetViewModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet3 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $cmdColor;
    public final /* synthetic */ WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded $viewState;
    public final /* synthetic */ WidgetApplicationCommandBottomSheet this$0;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                User user = WidgetApplicationCommandBottomSheet3.this.$viewState.getUser();
                if (user != null) {
                    WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
                    long id2 = user.getId();
                    Long channelId = WidgetApplicationCommandBottomSheet3.this.$viewState.getChannelId();
                    FragmentManager childFragmentManager = WidgetApplicationCommandBottomSheet3.this.this$0.getChildFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    WidgetUserSheet.Companion.show$default(companion, id2, channelId, childFragmentManager, WidgetApplicationCommandBottomSheet3.this.$viewState.getGuildId(), null, null, null, 112, null);
                }
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            GuildMember interactionUser = WidgetApplicationCommandBottomSheet3.this.$viewState.getInteractionUser();
            if (interactionUser != null) {
                hook.styles.add(new FontColorSpan(interactionUser.getColor()));
            }
            hook.styles.add(new ClickableSpan(null, false, null, new AnonymousClass2(), 4, null));
            hook.styles.add(new StyleSpan(1));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheet3(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet, WidgetApplicationCommandBottomSheetViewModel.ViewState.Loaded loaded, int i) {
        super(1);
        this.this$0 = widgetApplicationCommandBottomSheet;
        this.$viewState = loaded;
        this.$cmdColor = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Hook, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new StyleSpan(1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("usernameOnClick", new AnonymousClass1());
        renderContext.a("commandName", new AnonymousClass2());
        renderContext.a("applicationName", AnonymousClass3.INSTANCE);
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.sheet.WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Hook, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            Intrinsics3.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new FontColorSpan(WidgetApplicationCommandBottomSheet3.this.$cmdColor));
            hook.styles.add(new StyleSpan(1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.a;
        }
    }
}
