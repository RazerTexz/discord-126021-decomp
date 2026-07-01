package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandValue;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ApplicationCommandLocalSendData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationCommandLocalSendDataKt {
    public static final ApplicationCommandValue toRestParam(com.discord.widgets.chat.input.models.ApplicationCommandValue applicationCommandValue, Function1<? super ApplicationCommandValue, ApplicationCommandValue> function1) {
        m.checkNotNullParameter(applicationCommandValue, "$this$toRestParam");
        m.checkNotNullParameter(function1, "mappingFunction");
        String name = applicationCommandValue.getName();
        Object value = applicationCommandValue.getValue();
        List<com.discord.widgets.chat.input.models.ApplicationCommandValue> options = applicationCommandValue.getOptions();
        return new ApplicationCommandValue(name, value, applicationCommandValue.getType(), options != null ? toRestParams(options, function1) : null, applicationCommandValue.getFocused());
    }

    public static final List<ApplicationCommandValue> toRestParams(List<com.discord.widgets.chat.input.models.ApplicationCommandValue> list, Function1<? super ApplicationCommandValue, ApplicationCommandValue> function1) {
        m.checkNotNullParameter(list, "$this$toRestParams");
        m.checkNotNullParameter(function1, "mappingFunction");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke(toRestParam((com.discord.widgets.chat.input.models.ApplicationCommandValue) it.next(), function1)));
        }
        return arrayList;
    }
}
