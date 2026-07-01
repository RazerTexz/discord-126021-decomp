package com.google.android.material.badge;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import androidx.annotation.StringRes;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.resources.TextAppearance;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public final class BadgeDrawable$SavedState implements Parcelable {
    public static final Parcelable$Creator<BadgeDrawable$SavedState> CREATOR = new BadgeDrawable$SavedState$a();
    private int alpha;

    @ColorInt
    private int backgroundColor;
    private int badgeGravity;

    @ColorInt
    private int badgeTextColor;

    @StringRes
    private int contentDescriptionExceedsMaxBadgeNumberRes;

    @Nullable
    private CharSequence contentDescriptionNumberless;

    @PluralsRes
    private int contentDescriptionQuantityStrings;

    @Dimension(unit = 1)
    private int horizontalOffset;
    private boolean isVisible;
    private int maxCharacterCount;
    private int number;

    @Dimension(unit = 1)
    private int verticalOffset;

    public BadgeDrawable$SavedState(@NonNull Context context) {
        this.alpha = 255;
        this.number = -1;
        this.badgeTextColor = new TextAppearance(context, R$style.TextAppearance_MaterialComponents_Badge).textColor.getDefaultColor();
        this.contentDescriptionNumberless = context.getString(R$string.mtrl_badge_numberless_content_description);
        this.contentDescriptionQuantityStrings = R$plurals.mtrl_badge_content_description;
        this.contentDescriptionExceedsMaxBadgeNumberRes = R$string.mtrl_exceed_max_badge_number_content_description;
        this.isVisible = true;
    }

    public static /* synthetic */ boolean access$000(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.isVisible;
    }

    public static /* synthetic */ boolean access$002(BadgeDrawable$SavedState badgeDrawable$SavedState, boolean z2) {
        badgeDrawable$SavedState.isVisible = z2;
        return z2;
    }

    public static /* synthetic */ int access$100(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.maxCharacterCount;
    }

    public static /* synthetic */ int access$1000(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.contentDescriptionQuantityStrings;
    }

    public static /* synthetic */ int access$1002(BadgeDrawable$SavedState badgeDrawable$SavedState, int i) {
        badgeDrawable$SavedState.contentDescriptionQuantityStrings = i;
        return i;
    }

    public static /* synthetic */ int access$102(BadgeDrawable$SavedState badgeDrawable$SavedState, int i) {
        badgeDrawable$SavedState.maxCharacterCount = i;
        return i;
    }

    public static /* synthetic */ int access$1100(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.contentDescriptionExceedsMaxBadgeNumberRes;
    }

    public static /* synthetic */ int access$1102(BadgeDrawable$SavedState badgeDrawable$SavedState, int i) {
        badgeDrawable$SavedState.contentDescriptionExceedsMaxBadgeNumberRes = i;
        return i;
    }

    public static /* synthetic */ int access$200(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.number;
    }

    public static /* synthetic */ int access$202(BadgeDrawable$SavedState badgeDrawable$SavedState, int i) {
        badgeDrawable$SavedState.number = i;
        return i;
    }

    public static /* synthetic */ int access$300(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.backgroundColor;
    }

    public static /* synthetic */ int access$302(BadgeDrawable$SavedState badgeDrawable$SavedState, int i) {
        badgeDrawable$SavedState.backgroundColor = i;
        return i;
    }

    public static /* synthetic */ int access$400(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.badgeTextColor;
    }

    public static /* synthetic */ int access$402(BadgeDrawable$SavedState badgeDrawable$SavedState, int i) {
        badgeDrawable$SavedState.badgeTextColor = i;
        return i;
    }

    public static /* synthetic */ int access$500(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.badgeGravity;
    }

    public static /* synthetic */ int access$502(BadgeDrawable$SavedState badgeDrawable$SavedState, int i) {
        badgeDrawable$SavedState.badgeGravity = i;
        return i;
    }

    public static /* synthetic */ int access$600(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.horizontalOffset;
    }

    public static /* synthetic */ int access$602(BadgeDrawable$SavedState badgeDrawable$SavedState, int i) {
        badgeDrawable$SavedState.horizontalOffset = i;
        return i;
    }

    public static /* synthetic */ int access$700(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.verticalOffset;
    }

    public static /* synthetic */ int access$702(BadgeDrawable$SavedState badgeDrawable$SavedState, int i) {
        badgeDrawable$SavedState.verticalOffset = i;
        return i;
    }

    public static /* synthetic */ int access$800(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.alpha;
    }

    public static /* synthetic */ int access$802(BadgeDrawable$SavedState badgeDrawable$SavedState, int i) {
        badgeDrawable$SavedState.alpha = i;
        return i;
    }

    public static /* synthetic */ CharSequence access$900(BadgeDrawable$SavedState badgeDrawable$SavedState) {
        return badgeDrawable$SavedState.contentDescriptionNumberless;
    }

    public static /* synthetic */ CharSequence access$902(BadgeDrawable$SavedState badgeDrawable$SavedState, CharSequence charSequence) {
        badgeDrawable$SavedState.contentDescriptionNumberless = charSequence;
        return charSequence;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.backgroundColor);
        parcel.writeInt(this.badgeTextColor);
        parcel.writeInt(this.alpha);
        parcel.writeInt(this.number);
        parcel.writeInt(this.maxCharacterCount);
        parcel.writeString(this.contentDescriptionNumberless.toString());
        parcel.writeInt(this.contentDescriptionQuantityStrings);
        parcel.writeInt(this.badgeGravity);
        parcel.writeInt(this.horizontalOffset);
        parcel.writeInt(this.verticalOffset);
        parcel.writeInt(this.isVisible ? 1 : 0);
    }

    public BadgeDrawable$SavedState(@NonNull Parcel parcel) {
        this.alpha = 255;
        this.number = -1;
        this.backgroundColor = parcel.readInt();
        this.badgeTextColor = parcel.readInt();
        this.alpha = parcel.readInt();
        this.number = parcel.readInt();
        this.maxCharacterCount = parcel.readInt();
        this.contentDescriptionNumberless = parcel.readString();
        this.contentDescriptionQuantityStrings = parcel.readInt();
        this.badgeGravity = parcel.readInt();
        this.horizontalOffset = parcel.readInt();
        this.verticalOffset = parcel.readInt();
        this.isVisible = parcel.readInt() != 0;
    }
}
