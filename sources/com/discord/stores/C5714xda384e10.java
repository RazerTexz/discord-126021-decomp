package com.discord.stores;

import com.discord.api.commands.ApplicationCommandValue;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1 */
/* JADX INFO: compiled from: StoreApplicationCommands.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C5714xda384e10 extends AbstractC12240o implements Function1<ApplicationCommandValue, ApplicationCommandValue> {
    public static final C5714xda384e10 INSTANCE = new C5714xda384e10();

    public C5714xda384e10() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ApplicationCommandValue invoke(ApplicationCommandValue applicationCommandValue) {
        C12238m.checkNotNullParameter(applicationCommandValue, "it");
        return applicationCommandValue;
    }
}
