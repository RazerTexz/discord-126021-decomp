package com.discord.stores;

import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuiltInCommands$createWrappedSlashCommand$1 extends o implements Function1<Map<String, ? extends Object>, String> {
    public final /* synthetic */ String $wrapper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuiltInCommands$createWrappedSlashCommand$1(String str) {
        super(1);
        this.$wrapper = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(Map<String, ? extends Object> map) {
        return invoke2(map);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(Map<String, ? extends Object> map) {
        m.checkNotNullParameter(map, "commandOptions");
        StringBuilder sb = new StringBuilder();
        sb.append(this.$wrapper);
        Object obj = map.get("message");
        if (obj == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(this.$wrapper);
        return sb.toString();
    }
}
