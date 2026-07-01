package com.discord.widgets.servers;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsEditRole.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditRole$setupActionBar$1 extends o implements Function2<String, Integer, SpannableStringBuilder> {
    public static final WidgetServerSettingsEditRole$setupActionBar$1 INSTANCE = new WidgetServerSettingsEditRole$setupActionBar$1();

    public WidgetServerSettingsEditRole$setupActionBar$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ SpannableStringBuilder invoke(String str, Integer num) {
        return invoke(str, num.intValue());
    }

    public final SpannableStringBuilder invoke(String str, @ColorInt int i) {
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, spannableStringBuilder.length(), 0);
        return spannableStringBuilder;
    }
}
