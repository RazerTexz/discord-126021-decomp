package com.discord.widgets.chat.input.models;

import d0.z.d.m;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ApplicationCommandData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationCommandDataKt {
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:34:0x0073  */
    /* JADX WARN: Code duplicated, block: B:35:0x0075  */
    /* JADX WARN: Code duplicated, block: B:57:0x0078 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:? A[LOOP:2: B:30:0x0060->B:61:?, LOOP_END, SYNTHETIC] */
    public static final String getCommandId(ApplicationCommandData applicationCommandData) {
        Object obj;
        Object next;
        ApplicationCommandValue applicationCommandValue;
        boolean z2;
        List<ApplicationCommandValue> options;
        Object next2;
        m.checkNotNullParameter(applicationCommandData, "$this$getCommandId");
        Iterator<T> it = applicationCommandData.getValues().iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((ApplicationCommandValue) next).getType() == 2));
        ApplicationCommandValue applicationCommandValue2 = (ApplicationCommandValue) next;
        if (applicationCommandValue2 == null || (options = applicationCommandValue2.getOptions()) == null) {
            for (Object obj2 : applicationCommandData.getValues()) {
                if (((ApplicationCommandValue) obj2).getType() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    obj = obj2;
                    break;
                }
            }
            applicationCommandValue = (ApplicationCommandValue) obj;
        } else {
            Iterator<T> it2 = options.iterator();
            do {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
            } while (!(((ApplicationCommandValue) next2).getType() == 1));
            applicationCommandValue = (ApplicationCommandValue) next2;
            if (applicationCommandValue == null) {
                while (r0.hasNext()) {
                    if (((ApplicationCommandValue) obj2).getType() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        obj = obj2;
                        break;
                    }
                }
                applicationCommandValue = (ApplicationCommandValue) obj;
            }
        }
        if (applicationCommandValue2 == null || applicationCommandValue == null) {
            if (applicationCommandValue == null) {
                return applicationCommandData.getApplicationCommand().getId();
            }
            return applicationCommandData.getApplicationCommand().getId() + " " + applicationCommandValue.getName();
        }
        return applicationCommandData.getApplicationCommand().getId() + " " + applicationCommandValue2.getName() + " " + applicationCommandValue.getName();
    }
}
