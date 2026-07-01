package com.discord.utilities.stateful;

import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.views.CheckedSetting;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.t.k;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;

/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StatefulViews {
    private final List<Integer> ids;
    private final HashMap<Integer, Boolean> requiredFieldIds;
    private final HashMap<Integer, Object> viewValues;
    private final HashMap<Integer, Object> viewValuesEdited;

    public StatefulViews(List<Integer> list) {
        m.checkNotNullParameter(list, "ids");
        this.ids = list;
        this.viewValues = new HashMap<>();
        this.viewValuesEdited = new HashMap<>();
        this.requiredFieldIds = new HashMap<>();
    }

    public static final /* synthetic */ boolean access$hasAnythingChanged(StatefulViews statefulViews) {
        return statefulViews.hasAnythingChanged();
    }

    public static /* synthetic */ void clear$default(StatefulViews statefulViews, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        statefulViews.clear(z2);
    }

    private final <T> T get(int id2) {
        return (T) (this.viewValuesEdited.containsKey(Integer.valueOf(id2)) ? this.viewValuesEdited : this.viewValues).get(Integer.valueOf(id2));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0072  */
    private final boolean hasAnythingChanged() {
        boolean z2;
        List<Integer> list = this.ids;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                if (this.viewValuesEdited.containsKey(Integer.valueOf(iIntValue))) {
                    Object string = this.viewValuesEdited.get(Integer.valueOf(iIntValue));
                    if (string instanceof SpannableStringBuilder) {
                        string = string.toString();
                    }
                    if (!m.areEqual(string, this.viewValues.get(Integer.valueOf(iIntValue)) instanceof SpannableStringBuilder ? String.valueOf(this.viewValues.get(Integer.valueOf(iIntValue))) : this.viewValues.get(Integer.valueOf(iIntValue)))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x004b  */
    private final boolean isAnyRequiredFieldBlank() {
        boolean z2;
        HashMap<Integer, Boolean> map = this.requiredFieldIds;
        if (!map.isEmpty()) {
            for (Map$Entry<Integer, Boolean> map$Entry : map.entrySet()) {
                int iIntValue = map$Entry.getKey().intValue();
                if (map$Entry.getValue().booleanValue()) {
                    Object obj = get(iIntValue);
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    String str = (String) obj;
                    if (str == null || !t.isBlank(str)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void addOptionalFields(View... views) {
        m.checkNotNullParameter(views, "views");
        for (View view : views) {
            this.requiredFieldIds.put(Integer.valueOf(view.getId()), Boolean.FALSE);
        }
    }

    public final void clear() {
        clear$default(this, false, 1, null);
    }

    public final void clear(boolean clearDefaults) {
        this.viewValuesEdited.clear();
        if (clearDefaults) {
            this.viewValues.clear();
        }
    }

    public final void configureSaveActionView(View saveActionView) {
        StatefulViews$configureSaveActionView$1 statefulViews$configureSaveActionView$1 = StatefulViews$configureSaveActionView$1.INSTANCE;
        StatefulViews$configureSaveActionView$2 statefulViews$configureSaveActionView$2 = StatefulViews$configureSaveActionView$2.INSTANCE;
        if (saveActionView != null) {
            if (!hasAnythingChanged() || isAnyRequiredFieldBlank()) {
                statefulViews$configureSaveActionView$1.invoke2(saveActionView);
            } else {
                statefulViews$configureSaveActionView$2.invoke2(saveActionView);
            }
        }
    }

    public final <T> T getIfChanged(int id2) {
        if (hasChanged(id2)) {
            return (T) this.viewValuesEdited.get(Integer.valueOf(id2));
        }
        return null;
    }

    public final boolean hasChanged(int viewId) {
        if (this.viewValuesEdited.containsKey(Integer.valueOf(viewId))) {
            return !m.areEqual(this.viewValuesEdited.get(Integer.valueOf(viewId)), this.viewValues.get(Integer.valueOf(viewId)));
        }
        return false;
    }

    public final <T> void put(int id2, T value) {
        this.viewValuesEdited.put(Integer.valueOf(id2), value);
    }

    public final void setupTextWatcherWithSaveAction(AppFragment fragment, View saveAction, View... views) {
        m.checkNotNullParameter(fragment, "fragment");
        m.checkNotNullParameter(views, "views");
        for (View view : views) {
            HashMap<Integer, Boolean> map = this.requiredFieldIds;
            Integer numValueOf = Integer.valueOf(view.getId());
            Boolean bool = this.requiredFieldIds.get(Integer.valueOf(view.getId()));
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            m.checkNotNullExpressionValue(bool, "requiredFieldIds[view.id] ?: true");
            map.put(numValueOf, bool);
            StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$1 statefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$1 = new StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$1(view, this, saveAction, fragment);
            StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2 statefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2 = new StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2(view, this, saveAction, fragment);
            if (view instanceof TextView) {
                TextWatcherKt.addBindedTextWatcher((TextView) view, fragment, statefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$1);
            } else if (view instanceof TextInputLayout) {
                ViewExtensions.addBindedTextWatcher((TextInputLayout) view, fragment, statefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$1);
            } else {
                if (!(view instanceof CheckedSetting)) {
                    throw new UnsupportedOperationException(view + " must support using `TextWatcher`.");
                }
                ((CheckedSetting) view).setOnCheckedListener(new StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$3(statefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$2));
            }
        }
    }

    public final void setupUnsavedChangesConfirmation(AppFragment fragment) {
        StatefulViews$FragmentOnBackPressedHandler statefulViews$FragmentOnBackPressedHandler;
        m.checkNotNullParameter(fragment, "fragment");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            m.checkNotNullExpressionValue(activity, "it");
            statefulViews$FragmentOnBackPressedHandler = new StatefulViews$FragmentOnBackPressedHandler(activity, new StatefulViews$setupUnsavedChangesConfirmation$$inlined$let$lambda$1(this));
        } else {
            statefulViews$FragmentOnBackPressedHandler = null;
        }
        AppFragment.setOnBackPressed$default(fragment, new StatefulViews$setupUnsavedChangesConfirmation$1(statefulViews$FragmentOnBackPressedHandler), 0, 2, null);
    }

    public final <T> T get(int id2, T defaultValue) {
        this.viewValues.put(Integer.valueOf(id2), defaultValue);
        T t = (T) get(id2);
        return (!m.areEqual(this.requiredFieldIds.get(Integer.valueOf(id2)), Boolean.FALSE) && t == null) ? defaultValue : t;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatefulViews(int... iArr) {
        this(k.toList(iArr));
        m.checkNotNullParameter(iArr, "ids");
    }

    public StatefulViews(Collection<? extends View> collection) {
        m.checkNotNullParameter(collection, "views");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((View) it.next()).getId()));
        }
        this((List<Integer>) arrayList);
    }
}
