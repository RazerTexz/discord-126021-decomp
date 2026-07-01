package com.discord.widgets.settings.profile;

import b.k.a.a.f;
import com.discord.utilities.color.ColorCompat;

/* JADX INFO: compiled from: WidgetEditProfileBannerSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditProfileBannerSheet$launchColorPicker$1 implements f {
    public final /* synthetic */ WidgetEditProfileBannerSheet this$0;

    public WidgetEditProfileBannerSheet$launchColorPicker$1(WidgetEditProfileBannerSheet widgetEditProfileBannerSheet) {
        this.this$0 = widgetEditProfileBannerSheet;
    }

    @Override // b.k.a.a.f
    public void onColorReset(int dialogId) {
        WidgetEditProfileBannerSheet.access$getViewModel$p(this.this$0).updateColorPreview(null);
        this.this$0.getOnColorSelected().invoke(null);
    }

    @Override // b.k.a.a.f
    public void onColorSelected(int dialogId, int selectedColor) {
        EditProfileBannerSheetViewModel editProfileBannerSheetViewModelAccess$getViewModel$p = WidgetEditProfileBannerSheet.access$getViewModel$p(this.this$0);
        ColorCompat colorCompat = ColorCompat.INSTANCE;
        editProfileBannerSheetViewModelAccess$getViewModel$p.updateColorPreview(colorCompat.getColorHexFromColorInt(selectedColor));
        this.this$0.getOnColorSelected().invoke(Integer.valueOf(colorCompat.removeAlphaComponent(selectedColor)));
    }

    @Override // b.k.a.a.f
    public void onDialogDismissed(int dialogId) {
    }
}
