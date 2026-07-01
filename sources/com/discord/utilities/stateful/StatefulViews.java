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
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.views.CheckedSetting;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import rx.functions.Action1;
import rx.functions.Func0;

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
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(function0, "hasAnythingChanged");
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
            ViewDialogConfirmationBinding viewDialogConfirmationBindingB = ViewDialogConfirmationBinding.b(LayoutInflater.from(this.activity));
            Intrinsics3.checkNotNullExpressionValue(viewDialogConfirmationBindingB, "ViewDialogConfirmationBi…tInflater.from(activity))");
            final AlertDialog alertDialogCreate = new AlertDialog.Builder(this.activity).setView(viewDialogConfirmationBindingB.a).create();
            Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(acti…logBinding.root).create()");
            viewDialogConfirmationBindingB.d.setText(R.string.discard_changes);
            viewDialogConfirmationBindingB.e.setText(R.string.discard_changes_description);
            viewDialogConfirmationBindingB.f2185b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.utilities.stateful.StatefulViews$FragmentOnBackPressedHandler$onBackPressed$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    alertDialogCreate.dismiss();
                }
            });
            viewDialogConfirmationBindingB.c.setText(R.string.okay);
            viewDialogConfirmationBindingB.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.utilities.stateful.StatefulViews$FragmentOnBackPressedHandler$onBackPressed$2
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

    /* JADX INFO: renamed from: com.discord.utilities.stateful.StatefulViews$configureSaveActionView$1, reason: invalid class name */
    /* JADX INFO: compiled from: StatefulViews.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "$this$smartHide");
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).hide();
            } else {
                view.setVisibility(8);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.stateful.StatefulViews$configureSaveActionView$2, reason: invalid class name */
    /* JADX INFO: compiled from: StatefulViews.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "$this$smartShow");
            if (view instanceof FloatingActionButton) {
                ((FloatingActionButton) view).show();
            } else {
                view.setVisibility(0);
            }
        }
    }

    public StatefulViews(List<Integer> list) {
        Intrinsics3.checkNotNullParameter(list, "ids");
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
                    if (!Intrinsics3.areEqual(string, this.viewValues.get(Integer.valueOf(iIntValue)) instanceof SpannableStringBuilder ? String.valueOf(this.viewValues.get(Integer.valueOf(iIntValue))) : this.viewValues.get(Integer.valueOf(iIntValue)))) {
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
                    if (str == null || !StringsJVM.isBlank(str)) {
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
        Intrinsics3.checkNotNullParameter(views, "views");
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
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        AnonymousClass2 anonymousClass2 = AnonymousClass2.INSTANCE;
        if (saveActionView != null) {
            if (!hasAnythingChanged() || isAnyRequiredFieldBlank()) {
                anonymousClass1.invoke2(saveActionView);
            } else {
                anonymousClass2.invoke2(saveActionView);
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
            return !Intrinsics3.areEqual(this.viewValuesEdited.get(Integer.valueOf(viewId)), this.viewValues.get(Integer.valueOf(viewId)));
        }
        return false;
    }

    public final <T> void put(int id2, T value) {
        this.viewValuesEdited.put(Integer.valueOf(id2), value);
    }

    public final void setupTextWatcherWithSaveAction(AppFragment fragment, View saveAction, View... views) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(views, "views");
        for (View view : views) {
            HashMap<Integer, Boolean> map = this.requiredFieldIds;
            Integer numValueOf = Integer.valueOf(view.getId());
            Boolean bool = this.requiredFieldIds.get(Integer.valueOf(view.getId()));
            if (bool == null) {
                bool = Boolean.TRUE;
            }
            Intrinsics3.checkNotNullExpressionValue(bool, "requiredFieldIds[view.id] ?: true");
            map.put(numValueOf, bool);
            StatefulViews4 statefulViews4 = new StatefulViews4(view, this, saveAction, fragment);
            final StatefulViews5 statefulViews5 = new StatefulViews5(view, this, saveAction, fragment);
            if (view instanceof TextView) {
                TextWatcher4.addBindedTextWatcher((TextView) view, fragment, statefulViews4);
            } else if (view instanceof TextInputLayout) {
                ViewExtensions.addBindedTextWatcher((TextInputLayout) view, fragment, statefulViews4);
            } else {
                if (!(view instanceof CheckedSetting)) {
                    throw new UnsupportedOperationException(view + " must support using `TextWatcher`.");
                }
                ((CheckedSetting) view).setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.utilities.stateful.StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$3
                    @Override // rx.functions.Action1
                    public final void call(Boolean bool2) {
                        StatefulViews5 statefulViews6 = statefulViews5;
                        Intrinsics3.checkNotNullExpressionValue(bool2, "it");
                        statefulViews6.invoke(bool2.booleanValue());
                    }
                });
            }
        }
    }

    public final void setupUnsavedChangesConfirmation(AppFragment fragment) {
        final FragmentOnBackPressedHandler fragmentOnBackPressedHandler;
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        FragmentActivity fragmentActivityE = fragment.e();
        if (fragmentActivityE != null) {
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityE, "it");
            fragmentOnBackPressedHandler = new FragmentOnBackPressedHandler(fragmentActivityE, new StatefulViews7(this));
        } else {
            fragmentOnBackPressedHandler = null;
        }
        AppFragment.setOnBackPressed$default(fragment, new Func0<Boolean>() { // from class: com.discord.utilities.stateful.StatefulViews.setupUnsavedChangesConfirmation.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                FragmentOnBackPressedHandler fragmentOnBackPressedHandler2 = fragmentOnBackPressedHandler;
                return fragmentOnBackPressedHandler2 != null ? Boolean.valueOf(fragmentOnBackPressedHandler2.onBackPressed()) : Boolean.FALSE;
            }
        }, 0, 2, null);
    }

    public final <T> T get(int id2, T defaultValue) {
        this.viewValues.put(Integer.valueOf(id2), defaultValue);
        T t = (T) get(id2);
        return (!Intrinsics3.areEqual(this.requiredFieldIds.get(Integer.valueOf(id2)), Boolean.FALSE) && t == null) ? defaultValue : t;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatefulViews(int... iArr) {
        this(_Arrays.toList(iArr));
        Intrinsics3.checkNotNullParameter(iArr, "ids");
    }

    public StatefulViews(Collection<? extends View> collection) {
        Intrinsics3.checkNotNullParameter(collection, "views");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((View) it.next()).getId()));
        }
        this((List<Integer>) arrayList);
    }
}
