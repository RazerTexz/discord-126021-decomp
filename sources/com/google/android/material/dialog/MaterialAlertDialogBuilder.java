package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface$OnClickListener;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnKeyListener;
import android.content.DialogInterface$OnMultiChoiceClickListener;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.ListAdapter;
import androidx.annotation.ArrayRes;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialAlertDialogBuilder extends AlertDialog$Builder {

    @AttrRes
    private static final int DEF_STYLE_ATTR = R$attr.alertDialogStyle;

    @StyleRes
    private static final int DEF_STYLE_RES = R$style.MaterialAlertDialog_MaterialComponents;

    @AttrRes
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = R$attr.materialAlertDialogTheme;

    @Nullable
    private Drawable background;

    @NonNull
    @Dimension
    private final Rect backgroundInsets;

    public MaterialAlertDialogBuilder(@NonNull Context context) {
        this(context, 0);
    }

    private static Context createMaterialAlertDialogThemedContext(@NonNull Context context) {
        int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
        Context contextWrap = MaterialThemeOverlay.wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        return materialAlertDialogThemeOverlay == 0 ? contextWrap : new ContextThemeWrapper(contextWrap, materialAlertDialogThemeOverlay);
    }

    private static int getMaterialAlertDialogThemeOverlay(@NonNull Context context) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (typedValueResolve == null) {
            return 0;
        }
        return typedValueResolve.data;
    }

    private static int getOverridingThemeResId(@NonNull Context context, int i) {
        return i == 0 ? getMaterialAlertDialogThemeOverlay(context) : i;
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public AlertDialog create() {
        AlertDialog alertDialogCreate = super.create();
        Window window = alertDialogCreate.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.background;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).setElevation(ViewCompat.getElevation(decorView));
        }
        window.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(alertDialogCreate, this.backgroundInsets));
        return alertDialogCreate;
    }

    @Nullable
    public Drawable getBackground() {
        return this.background;
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setAdapter(@Nullable ListAdapter listAdapter, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setAdapter(listAdapter, dialogInterface$OnClickListener);
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackground(@Nullable Drawable drawable) {
        this.background = drawable;
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetBottom(@Px int i) {
        this.backgroundInsets.bottom = i;
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetEnd(@Px int i) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.left = i;
        } else {
            this.backgroundInsets.right = i;
        }
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetStart(@Px int i) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.right = i;
        } else {
            this.backgroundInsets.left = i;
        }
        return this;
    }

    @NonNull
    public MaterialAlertDialogBuilder setBackgroundInsetTop(@Px int i) {
        this.backgroundInsets.top = i;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setCancelable(boolean z2) {
        return setCancelable(z2);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setCursor(@Nullable Cursor cursor, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener, @NonNull String str) {
        return setCursor(cursor, dialogInterface$OnClickListener, str);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setCustomTitle(@Nullable View view) {
        return setCustomTitle(view);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setIcon(@DrawableRes int i) {
        return setIcon(i);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setIconAttribute(@AttrRes int i) {
        return setIconAttribute(i);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setItems(@ArrayRes int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setItems(i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setMessage(@StringRes int i) {
        return setMessage(i);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setMultiChoiceItems(@ArrayRes int i, @Nullable boolean[] zArr, @Nullable DialogInterface$OnMultiChoiceClickListener dialogInterface$OnMultiChoiceClickListener) {
        return setMultiChoiceItems(i, zArr, dialogInterface$OnMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setNegativeButton(@StringRes int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setNegativeButton(i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setNegativeButtonIcon(@Nullable Drawable drawable) {
        return setNegativeButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setNeutralButton(@StringRes int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setNeutralButton(i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setNeutralButtonIcon(@Nullable Drawable drawable) {
        return setNeutralButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setOnCancelListener(@Nullable DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        return setOnCancelListener(dialogInterface$OnCancelListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setOnDismissListener(@Nullable DialogInterface$OnDismissListener dialogInterface$OnDismissListener) {
        return setOnDismissListener(dialogInterface$OnDismissListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setOnItemSelectedListener(@Nullable AdapterView$OnItemSelectedListener adapterView$OnItemSelectedListener) {
        return setOnItemSelectedListener(adapterView$OnItemSelectedListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setOnKeyListener(@Nullable DialogInterface$OnKeyListener dialogInterface$OnKeyListener) {
        return setOnKeyListener(dialogInterface$OnKeyListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setPositiveButton(@StringRes int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setPositiveButton(i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setPositiveButtonIcon(@Nullable Drawable drawable) {
        return setPositiveButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setSingleChoiceItems(@ArrayRes int i, int i2, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setSingleChoiceItems(i, i2, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setTitle(@StringRes int i) {
        return setTitle(i);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setView(int i) {
        return setView(i);
    }

    public MaterialAlertDialogBuilder(@NonNull Context context, int i) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, i));
        Context context2 = getContext();
        Resources$Theme theme = context2.getTheme();
        int i2 = DEF_STYLE_ATTR;
        int i3 = DEF_STYLE_RES;
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, i2, i3);
        int color = MaterialColors.getColor(context2, R$attr.colorSurface, getClass().getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, i2, i3);
        materialShapeDrawable.initializeElevationOverlay(context2);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        if (Build$VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R$attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setAdapter(@Nullable ListAdapter listAdapter, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setAdapter(listAdapter, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setCancelable(boolean z2) {
        return (MaterialAlertDialogBuilder) super.setCancelable(z2);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setCursor(@Nullable Cursor cursor, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener, @NonNull String str) {
        return (MaterialAlertDialogBuilder) super.setCursor(cursor, dialogInterface$OnClickListener, str);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setCustomTitle(@Nullable View view) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(view);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setIcon(@Nullable Drawable drawable) {
        return setIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setIconAttribute(@AttrRes int i) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(i);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setItems(@Nullable CharSequence[] charSequenceArr, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setItems(charSequenceArr, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setMessage(@Nullable CharSequence charSequence) {
        return setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setMultiChoiceItems(@Nullable Cursor cursor, @NonNull String str, @NonNull String str2, @Nullable DialogInterface$OnMultiChoiceClickListener dialogInterface$OnMultiChoiceClickListener) {
        return setMultiChoiceItems(cursor, str, str2, dialogInterface$OnMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setNegativeButton(@Nullable CharSequence charSequence, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setNegativeButton(charSequence, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButtonIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setNeutralButton(@Nullable CharSequence charSequence, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setNeutralButton(charSequence, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButtonIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnCancelListener(@Nullable DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(dialogInterface$OnCancelListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnDismissListener(@Nullable DialogInterface$OnDismissListener dialogInterface$OnDismissListener) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(dialogInterface$OnDismissListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnItemSelectedListener(@Nullable AdapterView$OnItemSelectedListener adapterView$OnItemSelectedListener) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(adapterView$OnItemSelectedListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setOnKeyListener(@Nullable DialogInterface$OnKeyListener dialogInterface$OnKeyListener) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(dialogInterface$OnKeyListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setPositiveButton(@Nullable CharSequence charSequence, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setPositiveButton(charSequence, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButtonIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setSingleChoiceItems(@Nullable Cursor cursor, int i, @NonNull String str, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setSingleChoiceItems(cursor, i, str, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setTitle(@Nullable CharSequence charSequence) {
        return setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setView(@Nullable View view) {
        return setView(view);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@DrawableRes int i) {
        return (MaterialAlertDialogBuilder) super.setIcon(i);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setItems(@ArrayRes int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@StringRes int i) {
        return (MaterialAlertDialogBuilder) super.setMessage(i);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setMultiChoiceItems(@Nullable CharSequence[] charSequenceArr, @Nullable boolean[] zArr, @Nullable DialogInterface$OnMultiChoiceClickListener dialogInterface$OnMultiChoiceClickListener) {
        return setMultiChoiceItems(charSequenceArr, zArr, dialogInterface$OnMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@StringRes int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@StringRes int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@StringRes int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setSingleChoiceItems(@Nullable ListAdapter listAdapter, int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setSingleChoiceItems(listAdapter, i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@StringRes int i) {
        return (MaterialAlertDialogBuilder) super.setTitle(i);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setView(int i) {
        return (MaterialAlertDialogBuilder) super.setView(i);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setIcon(@Nullable Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setItems(@Nullable CharSequence[] charSequenceArr, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(charSequenceArr, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setMessage(@Nullable CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@ArrayRes int i, @Nullable boolean[] zArr, @Nullable DialogInterface$OnMultiChoiceClickListener dialogInterface$OnMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(i, zArr, dialogInterface$OnMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setNegativeButton(@Nullable CharSequence charSequence, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setNeutralButton(@Nullable CharSequence charSequence, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setPositiveButton(@Nullable CharSequence charSequence, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public /* bridge */ /* synthetic */ AlertDialog$Builder setSingleChoiceItems(@Nullable CharSequence[] charSequenceArr, int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return setSingleChoiceItems(charSequenceArr, i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setTitle(@Nullable CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setView(@Nullable View view) {
        return (MaterialAlertDialogBuilder) super.setView(view);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable CharSequence[] charSequenceArr, @Nullable boolean[] zArr, @Nullable DialogInterface$OnMultiChoiceClickListener dialogInterface$OnMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, dialogInterface$OnMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@ArrayRes int i, int i2, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(i, i2, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setMultiChoiceItems(@Nullable Cursor cursor, @NonNull String str, @NonNull String str2, @Nullable DialogInterface$OnMultiChoiceClickListener dialogInterface$OnMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, dialogInterface$OnMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable Cursor cursor, int i, @NonNull String str, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, i, str, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable CharSequence[] charSequenceArr, int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, i, dialogInterface$OnClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog$Builder
    @NonNull
    public MaterialAlertDialogBuilder setSingleChoiceItems(@Nullable ListAdapter listAdapter, int i, @Nullable DialogInterface$OnClickListener dialogInterface$OnClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, i, dialogInterface$OnClickListener);
    }
}
