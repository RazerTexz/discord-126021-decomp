package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandData3;
import com.discord.widgets.chat.input.models.ApplicationCommandValue;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.models.commands.ApplicationCommandLocalSendDataKt, reason: use source file name */
/* JADX INFO: compiled from: ApplicationCommandLocalSendData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationCommandLocalSendData3 {
    public static final ApplicationCommandData3 toRestParam(ApplicationCommandValue applicationCommandValue, Function1<? super ApplicationCommandData3, ApplicationCommandData3> function1) {
        Intrinsics3.checkNotNullParameter(applicationCommandValue, "$this$toRestParam");
        Intrinsics3.checkNotNullParameter(function1, "mappingFunction");
        String name = applicationCommandValue.getName();
        Object value = applicationCommandValue.getValue();
        List<ApplicationCommandValue> options = applicationCommandValue.getOptions();
        return new ApplicationCommandData3(name, value, applicationCommandValue.getType(), options != null ? toRestParams(options, function1) : null, applicationCommandValue.getFocused());
    }

    public static final List<ApplicationCommandData3> toRestParams(List<ApplicationCommandValue> list, Function1<? super ApplicationCommandData3, ApplicationCommandData3> function1) {
        Intrinsics3.checkNotNullParameter(list, "$this$toRestParams");
        Intrinsics3.checkNotNullParameter(function1, "mappingFunction");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(function1.invoke(toRestParam((ApplicationCommandValue) it.next(), function1)));
        }
        return arrayList;
    }
}
