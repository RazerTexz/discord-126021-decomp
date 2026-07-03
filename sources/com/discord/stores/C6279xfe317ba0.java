package com.discord.stores;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNux;
import com.discord.widgets.guilds.create.WidgetGuildClone;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$guildTemplateCodeNavHandler$1 */
/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C6279xfe317ba0 extends AbstractC12240o implements Function2<AppActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation, Boolean> {
    public final /* synthetic */ StoreNavigation.ActivityNavigationLifecycleCallbacks this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$guildTemplateCodeNavHandler$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNavigation.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
            C12238m.checkNotNullParameter(nuxState, "it");
            return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C6279xfe317ba0(StoreNavigation.ActivityNavigationLifecycleCallbacks activityNavigationLifecycleCallbacks) {
        super(2);
        this.this$0 = activityNavigationLifecycleCallbacks;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        return Boolean.valueOf(invoke2(appActivity, modelGlobalNavigation));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(AppActivity appActivity, StoreNavigation.ActivityNavigationLifecycleCallbacks.ModelGlobalNavigation modelGlobalNavigation) {
        C12238m.checkNotNullParameter(appActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        C12238m.checkNotNullParameter(modelGlobalNavigation, "model");
        String guildTemplateCode = modelGlobalNavigation.getGuildTemplateCode();
        if (guildTemplateCode == null || appActivity.m8348h(C12216a0.getOrCreateKotlinClass(WidgetGuildClone.class))) {
            return false;
        }
        WidgetGuildClone.INSTANCE.show(appActivity, guildTemplateCode, "Dynamic Link");
        this.this$0.stream.getNux().updateNux(AnonymousClass1.INSTANCE);
        return true;
    }
}
