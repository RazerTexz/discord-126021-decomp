package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.text.style.StyleSpan;
import com.discord.i18n.Hook;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Locale;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1(WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1 widgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1) {
        super(1);
        this.this$0 = widgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        Context context = WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(this.this$0.this$0).getContext();
        Integer autoArchiveDuration = this.this$0.$draftState.getAutoArchiveDuration();
        if (autoArchiveDuration == null) {
            autoArchiveDuration = this.this$0.$data.getDefaultAutoArchiveDuration();
        }
        String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(context, autoArchiveDuration != null ? autoArchiveDuration.intValue() : 1440);
        Locale locale = Locale.getDefault();
        m.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        Objects.requireNonNull(strAutoArchiveDurationName, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strAutoArchiveDurationName.toLowerCase(locale);
        m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        hook.replacementText = lowerCase;
        hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(this.this$0.this$0).getContext(), 2130968989)), true, null, new WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1$1(this), 4, null));
        hook.styles.add(new StyleSpan(1));
    }
}
