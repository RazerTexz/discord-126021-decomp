package com.discord.models.commands;

import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.discord.models.commands.ApplicationCommandKt, reason: use source file name */
/* JADX INFO: compiled from: ApplicationCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationCommand2 {
    public static final boolean hasPermission(ApplicationCommand applicationCommand, long j, List<Long> list) {
        Object next;
        Intrinsics3.checkNotNullParameter(applicationCommand, "$this$hasPermission");
        Intrinsics3.checkNotNullParameter(list, "roles");
        if (applicationCommand.getDefaultPermissions() == null) {
            return true;
        }
        if (applicationCommand.getPermissions() != null) {
            Boolean bool = applicationCommand.getPermissions().get(Long.valueOf(j));
            if (bool != null) {
                return bool.booleanValue();
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(applicationCommand.getPermissions().get(Long.valueOf(((Number) it.next()).longValue())));
            }
            Iterator it2 = arrayList.iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
            } while (!Intrinsics3.areEqual((Boolean) next, Boolean.TRUE));
            Boolean bool2 = (Boolean) next;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return applicationCommand.getDefaultPermissions().booleanValue();
    }
}
