package com.discord.widgets.settings.profile;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EditProfileBannerSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EditProfileBannerSheetViewModel$1 extends o implements Function1<EditProfileBannerSheetViewModel$StoreState, Unit> {
    public final /* synthetic */ EditProfileBannerSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProfileBannerSheetViewModel$1(EditProfileBannerSheetViewModel editProfileBannerSheetViewModel) {
        super(1);
        this.this$0 = editProfileBannerSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(EditProfileBannerSheetViewModel$StoreState editProfileBannerSheetViewModel$StoreState) {
        invoke2(editProfileBannerSheetViewModel$StoreState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(EditProfileBannerSheetViewModel$StoreState editProfileBannerSheetViewModel$StoreState) {
        EditProfileBannerSheetViewModel editProfileBannerSheetViewModel = this.this$0;
        m.checkNotNullExpressionValue(editProfileBannerSheetViewModel$StoreState, "storeState");
        EditProfileBannerSheetViewModel.access$handleStoreState(editProfileBannerSheetViewModel, editProfileBannerSheetViewModel$StoreState);
    }
}
