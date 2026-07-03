package com.discord.models.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationCommand.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationCommandKt {
    public static final boolean hasPermission(ApplicationCommand applicationCommand, long j, List<Long> list) {
        Object next;
        C12238m.checkNotNullParameter(applicationCommand, "$this$hasPermission");
        C12238m.checkNotNullParameter(list, "roles");
        if (applicationCommand.getDefaultPermissions() == null) {
            return true;
        }
        if (applicationCommand.getPermissions() != null) {
            Boolean bool = applicationCommand.getPermissions().get(Long.valueOf(j));
            if (bool != null) {
                return bool.booleanValue();
            }
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(list, 10));
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
            } while (!C12238m.areEqual((Boolean) next, Boolean.TRUE));
            Boolean bool2 = (Boolean) next;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return applicationCommand.getDefaultPermissions().booleanValue();
    }
}
