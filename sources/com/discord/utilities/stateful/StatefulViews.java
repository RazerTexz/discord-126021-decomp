package com.discord.utilities.stateful;

import android.app.Activity;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.functions.Action1;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StatefulViews {
    private final List<Integer> ids;
    private final HashMap<Integer, Boolean> requiredFieldIds;
    private final HashMap<Integer, Object> viewValues;
    private final HashMap<Integer, Object> viewValuesEdited;

    /* JADX INFO: compiled from: StatefulViews.kt */
    public static final class FragmentOnBackPressedHandler {
        private final Activity activity;
        private final AtomicBoolean discardConfirmed;
        private final Function0<Boolean> hasAnythingChanged;

        public FragmentOnBackPressedHandler(Activity activity, Function0<Boolean> function0) {
            C12238m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            C12238m.checkNotNullParameter(function0, "hasAnythingChanged");
            this.activity = activity;
            this.hasAnythingChanged = function0;
            this.discardConfirmed = new AtomicBoolean(false);
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final Function0<Boolean> getHasAnythingChanged() {
            return this.hasAnythingChanged;
        }

        public final boolean onBackPressed() {
            if (!this.hasAnythingChanged.invoke().booleanValue() || this.discardConfirmed.get()) {
                return false;
            }
            ViewDialogConfirmationBinding viewDialogConfirmationBindingM8394b = ViewDialogConfirmationBinding.m8394b(LayoutInflater.from(this.activity));
            C12238m.checkNotNullExpressionValue(viewDialogConfirmationBindingM8394b, "ViewDialogConfirmationBi…tInflater.from(activity))");
            final AlertDialog alertDialogCreate = new AlertDialog.Builder(this.activity).setView(viewDialogConfirmationBindingM8394b.f15420a).create();
            C12238m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(acti…logBinding.root).create()");
            viewDialogConfirmationBindingM8394b.f15423d.setText(C5419R.string.discard_changes);
            viewDialogConfirmationBindingM8394b.f15424e.setText(C5419R.string.discard_changes_description);
            viewDialogConfirmationBindingM8394b.f15421b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.utilities.stateful.StatefulViews$FragmentOnBackPressedHandler$onBackPressed$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    alertDialogCreate.dismiss();
                }
            });
            viewDialogConfirmationBindingM8394b.f15422c.setText(C5419R.string.okay);
            viewDialogConfirmationBindingM8394b.f15422c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.utilities.stateful.StatefulViews$FragmentOnBackPressedHandler$onBackPressed$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.discardConfirmed.set(true);
                    alertDialogCreate.dismiss();
                    this.this$0.getActivity().onBackPressed();
                }
            });
            alertDialogCreate.show();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.stateful.StatefulViews$configureSaveActionView$1 */
    /* JADX INFO: compiled from: StatefulViews.kt */
    public static final class C69181 extends AbstractC12240o implements Function1<View, Unit> {
        public static final C69181 INSTANCE = new C69181();

        public C69181() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "$this$smartHide");
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).hide();
            } else {
                view.setVisibility(8);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.stateful.StatefulViews$configureSaveActionView$2 */
    /* JADX INFO: compiled from: StatefulViews.kt */
    public static final class C69192 extends AbstractC12240o implements Function1<View, Unit> {
        public static final C69192 INSTANCE = new C69192();

        public C69192() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "$this$smartShow");
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).show();
            } else {
                view.setVisibility(0);
            }
        }
    }

    public StatefulViews(List<Integer> list) {
        C12238m.checkNotNullParameter(list, "ids");
        this.ids = list;
        this.viewValues = new HashMap<>();
        this.viewValuesEdited = new HashMap<>();
        this.requiredFieldIds = new HashMap<>();
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
                    if (!C12238m.areEqual(string, this.viewValues.get(Integer.valueOf(iIntValue)) instanceof SpannableStringBuilder ? String.valueOf(this.viewValues.get(Integer.valueOf(iIntValue))) : this.viewValues.get(Integer.valueOf(iIntValue)))) {
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
            for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                if (entry.getValue().booleanValue()) {
                    Object obj = get(iIntValue);
                    if (!(obj instanceof String)) {
                        obj = null;
                    }
                    String str = (String) obj;
                    if (str == null || !C12103t.isBlank(str)) {
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
        C12238m.checkNotNullParameter(views, "views");
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
        C69181 c69181 = C69181.INSTANCE;
        C69192 c69192 = C69192.INSTANCE;
        if (saveActionView != null) {
            if (!hasAnythingChanged() || isAnyRequiredFieldBlank()) {
                c69181.invoke2(saveActionView);
            } else {
                c69192.invoke2(saveActionView);
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
            return !C12238m.areEqual(this.viewValuesEdited.get(Integer.valueOf(viewId)), this.viewValues.get(Integer.valueOf(viewId)));
        }
        return false;
    }

    public final <T> void put(int id2, T value) {
        this.viewValuesEdited.put(Integer.valueOf(id2), value);
    }

    public final void setupTextWatcherWithSaveAction(AppFragment fragment, View saveAction, View... views) {
        C12238m.checkNotNullParameter(fragment, "fragment");
        C12238m.checkNotNullParameter(views, "views");
        for (View view : views) {
            HashMap<Integer, Boolean> map = this.requiredFieldIds;
            Integer numValueOf = Integer.valueOf(view.getId());
            Boolean bool = this.requiredFieldIds.get(Integer.valueOf(view.getId()));
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            C12238m.checkNotNullExpressionValue(bool, "requiredFieldIds[view.id] ?: true");
            map.put(numValueOf, bool);
            C6920x66d3a014 c6920x66d3a014 = new C6920x66d3a014(view, this, saveAction, fragment);
            final C6921x66d3a015 c6921x66d3a015 = new C6921x66d3a015(view, this, saveAction, fragment);
            if (view instanceof TextView) {
                TextWatcherKt.addBindedTextWatcher((TextView) view, fragment, c6920x66d3a014);
            } else if (view instanceof TextInputLayout) {
                ViewExtensions.addBindedTextWatcher((TextInputLayout) view, fragment, c6920x66d3a014);
            } else {
                if (!(view instanceof CheckedSetting)) {
                    throw new UnsupportedOperationException(view + " must support using `TextWatcher`.");
                }
                ((CheckedSetting) view).setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.utilities.stateful.StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$3
                    @Override // p658rx.functions.Action1
                    public final void call(Boolean bool2) {
                        C6921x66d3a015 c6921x66d3a016 = c6921x66d3a015;
                        C12238m.checkNotNullExpressionValue(bool2, "it");
                        c6921x66d3a016.invoke(bool2.booleanValue());
                    }
                });
            }
        }
    }

    public final void setupUnsavedChangesConfirmation(AppFragment fragment) {
        final FragmentOnBackPressedHandler fragmentOnBackPressedHandler;
        C12238m.checkNotNullParameter(fragment, "fragment");
        FragmentActivity fragmentActivityM95e = fragment.m95e();
        if (fragmentActivityM95e != null) {
            C12238m.checkNotNullExpressionValue(fragmentActivityM95e, "it");
            fragmentOnBackPressedHandler = new FragmentOnBackPressedHandler(fragmentActivityM95e, new C6923x3e7a4b1b(this));
        } else {
            fragmentOnBackPressedHandler = null;
        }
        AppFragment.setOnBackPressed$default(fragment, new Func0<Boolean>() { // from class: com.discord.utilities.stateful.StatefulViews.setupUnsavedChangesConfirmation.1
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                FragmentOnBackPressedHandler fragmentOnBackPressedHandler2 = fragmentOnBackPressedHandler;
                return fragmentOnBackPressedHandler2 != null ? Boolean.valueOf(fragmentOnBackPressedHandler2.onBackPressed()) : Boolean.FALSE;
            }
        }, 0, 2, null);
    }

    public final <T> T get(int id2, T defaultValue) {
        this.viewValues.put(Integer.valueOf(id2), defaultValue);
        T t = (T) get(id2);
        return (!C12238m.areEqual(this.requiredFieldIds.get(Integer.valueOf(id2)), Boolean.FALSE) && t == null) ? defaultValue : t;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatefulViews(int... iArr) {
        this(C12141k.toList(iArr));
        C12238m.checkNotNullParameter(iArr, "ids");
    }

    public StatefulViews(Collection<? extends View> collection) {
        C12238m.checkNotNullParameter(collection, "views");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((View) it.next()).getId()));
        }
        this((List<Integer>) arrayList);
    }
}
