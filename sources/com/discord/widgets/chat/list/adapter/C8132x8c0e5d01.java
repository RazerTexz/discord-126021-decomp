package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.discord.C5419R;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.textprocessing.SimpleRoundedBackgroundSpan;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1 */
/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8132x8c0e5d01 extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8132x8c0e5d01(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8422a("autoModHook", new AnonymousClass1());
        renderContext.m8422a("systemHook", new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new ForegroundColorSpan(ColorCompat.getColor(C8132x8c0e5d01.this.$context, C5419R.color.brand_new_360)));
            hook.styles.add(new StyleSpan(1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
    public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Hook, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<String, String> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str) {
                if (str == null) {
                    return null;
                }
                Locale locale = Locale.ROOT;
                C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
                String upperCase = str.toUpperCase(locale);
                C12238m.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return upperCase;
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Hook hook) {
            C12238m.checkNotNullParameter(hook, "$receiver");
            hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(C8132x8c0e5d01.this.$context, C5419R.attr.colorHeaderPrimary)));
            hook.styles.add(new AbsoluteSizeSpan(DimenUtils.dpToPixels(14)));
            hook.styles.add(new SimpleRoundedBackgroundSpan(8, 14, DimenUtils.dpToPixels(4), DimenUtils.dpToPixels(2), ColorCompat.getColor(C8132x8c0e5d01.this.$context, C5419R.color.brand_new_500), DimenUtils.dpToPixels(4), Integer.valueOf(ColorCompat.getColor(C8132x8c0e5d01.this.$context, C5419R.color.white)), false, AnonymousClass1.INSTANCE, -2, 128, null));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
            invoke2(hook);
            return Unit.f27425a;
        }
    }
}
