package com.discord.stores;

import com.discord.api.commands.ApplicationCommand;
import com.discord.models.commands.Application;
import d0.g0.s;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$getApplicationCommandsViaRest$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $commands;
    public final /* synthetic */ StoreApplicationCommands$getApplicationCommandsViaRest$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommands$getApplicationCommandsViaRest$1$1(StoreApplicationCommands$getApplicationCommandsViaRest$1 storeApplicationCommands$getApplicationCommandsViaRest$1, List list) {
        super(0);
        this.this$0 = storeApplicationCommands$getApplicationCommandsViaRest$1;
        this.$commands = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0130  */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List listEmptyList;
        Collection collectionEmptyList;
        Object next;
        boolean z2;
        Object next2;
        ApplicationCommand applicationCommand;
        StoreApplicationCommands.access$setDiscoverApplicationId$p(this.this$0.this$0, null);
        StoreApplicationCommands.access$setLoadingDiscoveryCommands$p(this.this$0.this$0, false);
        Iterator it = StoreApplicationCommands.access$getApplications$p(this.this$0.this$0).iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (((Application) it.next()).getId() == this.this$0.$applicationId) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            List list = this.$commands;
            int size = list != null ? list.size() : 0;
            ArrayList arrayList = new ArrayList(StoreApplicationCommands.access$getApplications$p(this.this$0.this$0));
            Application application = (Application) arrayList.remove(i);
            if (size > 0) {
                List list2 = this.$commands;
                if (list2 == null || (applicationCommand = (ApplicationCommand) list2.get(0)) == null) {
                    return;
                } else {
                    arrayList.add(i, new Application(applicationCommand.getApplicationId(), application.getName(), application.getIcon(), null, size, application.getBot(), application.getBuiltIn(), 8, null));
                }
            }
            StoreApplicationCommands.access$setApplications$p(this.this$0.this$0, arrayList);
            List list3 = this.$commands;
            if (list3 != null) {
                listEmptyList = new ArrayList(d0.t.o.collectionSizeOrDefault(list3, 10));
                Iterator it2 = list3.iterator();
                while (it2.hasNext()) {
                    listEmptyList.add(StoreApplicationCommandsKt.toSlashCommand((ApplicationCommand) it2.next()));
                }
            } else {
                listEmptyList = n.emptyList();
            }
            StoreApplicationCommands storeApplicationCommands = this.this$0.this$0;
            StoreApplicationCommands.access$handleGuildApplicationsUpdate(storeApplicationCommands, u.toList(StoreApplicationCommands.access$getApplications$p(storeApplicationCommands)));
            List<String> topCommandIds = StoreApplicationCommands.access$getStoreApplicationCommandFrecency$p(this.this$0.this$0).getTopCommandIds(0L);
            ArrayList<String> arrayList2 = new ArrayList();
            for (Object obj : topCommandIds) {
                String str = (String) obj;
                Integer intOrNull = s.toIntOrNull(str);
                if ((intOrNull != null ? intOrNull.intValue() : 0) >= 0) {
                    Iterator it3 = listEmptyList.iterator();
                    do {
                        if (!it3.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it3.next();
                    } while (!m.areEqual(((com.discord.models.commands.ApplicationCommand) next2).getId(), str));
                    if (next2 != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = true;
                }
                if (z2) {
                    arrayList2.add(obj);
                }
            }
            List listPlus = u.plus((Collection) listEmptyList, (Iterable) StoreApplicationCommands.access$getBuiltInCommandsProvider$p(this.this$0.this$0).getBuiltInCommands());
            Map mapAccess$getFrecencyCommands$p = StoreApplicationCommands.access$getFrecencyCommands$p(this.this$0.this$0);
            ArrayList arrayList3 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList2, 10));
            for (String str2 : arrayList2) {
                Iterator it4 = listPlus.iterator();
                do {
                    if (!it4.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it4.next();
                } while (!m.areEqual(((com.discord.models.commands.ApplicationCommand) next).getId(), str2));
                arrayList3.add((com.discord.models.commands.ApplicationCommand) next);
            }
            mapAccess$getFrecencyCommands$p.put(0L, u.filterNotNull(arrayList3));
            this.this$0.this$0.markChanged(StoreApplicationCommands.Companion.getFrecencyCommandsUpdate());
            StoreApplicationCommands.access$handleDiscoverCommandsUpdate(this.this$0.this$0, listEmptyList);
            List list4 = this.$commands;
            if (list4 != null) {
                collectionEmptyList = new ArrayList(d0.t.o.collectionSizeOrDefault(list4, 10));
                Iterator it5 = list4.iterator();
                while (it5.hasNext()) {
                    collectionEmptyList.add(StoreApplicationCommandsKt.toSlashCommand((ApplicationCommand) it5.next()));
                }
            } else {
                collectionEmptyList = n.emptyList();
            }
            StoreApplicationCommands.access$handleQueryCommandsUpdate(this.this$0.this$0, u.plus(collectionEmptyList, (Iterable) StoreApplicationCommands.access$getBuiltInCommandsProvider$p(this.this$0.this$0).getBuiltInCommands()));
        }
    }
}
