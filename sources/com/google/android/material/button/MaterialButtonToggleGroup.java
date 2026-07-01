package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils$TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.LinearLayout$LayoutParams;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearanceModel$Builder;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    @IdRes
    private int checkedId;
    private final MaterialButtonToggleGroup$c checkedStateTracker;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;
    private final LinkedHashSet<MaterialButtonToggleGroup$OnButtonCheckedListener> onButtonCheckedListeners;
    private final List<MaterialButtonToggleGroup$d> originalCornerData;
    private final MaterialButtonToggleGroup$e pressedStateTracker;
    private boolean selectionRequired;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;
    private static final String LOG_TAG = MaterialButtonToggleGroup.class.getSimpleName();
    private static final int DEF_STYLE_RES = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    public static /* synthetic */ int access$200(MaterialButtonToggleGroup materialButtonToggleGroup, View view) {
        return materialButtonToggleGroup.getIndexWithinVisibleButtons(view);
    }

    public static /* synthetic */ boolean access$300(MaterialButtonToggleGroup materialButtonToggleGroup) {
        return materialButtonToggleGroup.skipCheckedStateTracker;
    }

    public static /* synthetic */ boolean access$400(MaterialButtonToggleGroup materialButtonToggleGroup) {
        return materialButtonToggleGroup.singleSelection;
    }

    public static /* synthetic */ int access$502(MaterialButtonToggleGroup materialButtonToggleGroup, int i) {
        materialButtonToggleGroup.checkedId = i;
        return i;
    }

    public static /* synthetic */ boolean access$600(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2) {
        return materialButtonToggleGroup.updateCheckedStates(i, z2);
    }

    public static /* synthetic */ void access$700(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2) {
        materialButtonToggleGroup.dispatchOnButtonChecked(i, z2);
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton childButton = getChildButton(i);
            int iMin = Math.min(childButton.getStrokeWidth(), getChildButton(i - 1).getStrokeWidth());
            LinearLayout$LayoutParams linearLayout$LayoutParamsBuildLayoutParams = buildLayoutParams(childButton);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(linearLayout$LayoutParamsBuildLayoutParams, 0);
                MarginLayoutParamsCompat.setMarginStart(linearLayout$LayoutParamsBuildLayoutParams, -iMin);
                linearLayout$LayoutParamsBuildLayoutParams.topMargin = 0;
            } else {
                linearLayout$LayoutParamsBuildLayoutParams.bottomMargin = 0;
                linearLayout$LayoutParamsBuildLayoutParams.topMargin = -iMin;
                MarginLayoutParamsCompat.setMarginStart(linearLayout$LayoutParamsBuildLayoutParams, 0);
            }
            childButton.setLayoutParams(linearLayout$LayoutParamsBuildLayoutParams);
        }
        resetChildMargins(firstVisibleChildIndex);
    }

    @NonNull
    private LinearLayout$LayoutParams buildLayoutParams(@NonNull View view) {
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout$LayoutParams ? (LinearLayout$LayoutParams) layoutParams : new LinearLayout$LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void checkForced(int i) {
        setCheckedStateForView(i, true);
        updateCheckedStates(i, true);
        setCheckedId(i);
    }

    private void dispatchOnButtonChecked(@IdRes int i, boolean z2) {
        Iterator<MaterialButtonToggleGroup$OnButtonCheckedListener> it = this.onButtonCheckedListeners.iterator();
        while (it.hasNext()) {
            it.next().onButtonChecked(this, i, z2);
        }
    }

    private MaterialButton getChildButton(int i) {
        return (MaterialButton) getChildAt(i);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isChildVisible(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getIndexWithinVisibleButtons(@Nullable View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) == view) {
                return i;
            }
            if ((getChildAt(i2) instanceof MaterialButton) && isChildVisible(i2)) {
                i++;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    @Nullable
    private MaterialButtonToggleGroup$d getNewCornerData(int i, int i2, int i3) {
        MaterialButtonToggleGroup$d materialButtonToggleGroup$d = this.originalCornerData.get(i);
        if (i2 == i3) {
            return materialButtonToggleGroup$d;
        }
        boolean z2 = getOrientation() == 0;
        if (i == i2) {
            if (!z2) {
                CornerSize cornerSize = materialButtonToggleGroup$d.f3033b;
                CornerSize cornerSize2 = MaterialButtonToggleGroup$d.a;
                return new MaterialButtonToggleGroup$d(cornerSize, cornerSize2, materialButtonToggleGroup$d.c, cornerSize2);
            }
            CornerSize cornerSize3 = MaterialButtonToggleGroup$d.a;
            if (ViewUtils.isLayoutRtl(this)) {
                CornerSize cornerSize4 = MaterialButtonToggleGroup$d.a;
                return new MaterialButtonToggleGroup$d(cornerSize4, cornerSize4, materialButtonToggleGroup$d.c, materialButtonToggleGroup$d.d);
            }
            CornerSize cornerSize5 = materialButtonToggleGroup$d.f3033b;
            CornerSize cornerSize6 = materialButtonToggleGroup$d.e;
            CornerSize cornerSize7 = MaterialButtonToggleGroup$d.a;
            return new MaterialButtonToggleGroup$d(cornerSize5, cornerSize6, cornerSize7, cornerSize7);
        }
        if (i != i3) {
            return null;
        }
        if (!z2) {
            CornerSize cornerSize8 = MaterialButtonToggleGroup$d.a;
            return new MaterialButtonToggleGroup$d(cornerSize8, materialButtonToggleGroup$d.e, cornerSize8, materialButtonToggleGroup$d.d);
        }
        CornerSize cornerSize9 = MaterialButtonToggleGroup$d.a;
        if (!ViewUtils.isLayoutRtl(this)) {
            CornerSize cornerSize10 = MaterialButtonToggleGroup$d.a;
            return new MaterialButtonToggleGroup$d(cornerSize10, cornerSize10, materialButtonToggleGroup$d.c, materialButtonToggleGroup$d.d);
        }
        CornerSize cornerSize11 = materialButtonToggleGroup$d.f3033b;
        CornerSize cornerSize12 = materialButtonToggleGroup$d.e;
        CornerSize cornerSize13 = MaterialButtonToggleGroup$d.a;
        return new MaterialButtonToggleGroup$d(cornerSize11, cornerSize12, cornerSize13, cornerSize13);
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && isChildVisible(i2)) {
                i++;
            }
        }
        return i;
    }

    private boolean isChildVisible(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    private void resetChildMargins(int i) {
        if (getChildCount() == 0 || i == -1) {
            return;
        }
        LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams) getChildButton(i).getLayoutParams();
        if (getOrientation() == 1) {
            linearLayout$LayoutParams.topMargin = 0;
            linearLayout$LayoutParams.bottomMargin = 0;
        } else {
            MarginLayoutParamsCompat.setMarginEnd(linearLayout$LayoutParams, 0);
            MarginLayoutParamsCompat.setMarginStart(linearLayout$LayoutParams, 0);
            linearLayout$LayoutParams.leftMargin = 0;
            linearLayout$LayoutParams.rightMargin = 0;
        }
    }

    private void setCheckedId(int i) {
        this.checkedId = i;
        dispatchOnButtonChecked(i, true);
    }

    private void setCheckedStateForView(@IdRes int i, boolean z2) {
        View viewFindViewById = findViewById(i);
        if (viewFindViewById instanceof MaterialButton) {
            this.skipCheckedStateTracker = true;
            ((MaterialButton) viewFindViewById).setChecked(z2);
            this.skipCheckedStateTracker = false;
        }
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils$TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.addOnCheckedChangeListener(this.checkedStateTracker);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private static void updateBuilderWithCornerData(ShapeAppearanceModel$Builder shapeAppearanceModel$Builder, @Nullable MaterialButtonToggleGroup$d materialButtonToggleGroup$d) {
        if (materialButtonToggleGroup$d == null) {
            shapeAppearanceModel$Builder.setAllCornerSizes(0.0f);
        } else {
            shapeAppearanceModel$Builder.setTopLeftCornerSize(materialButtonToggleGroup$d.f3033b).setBottomLeftCornerSize(materialButtonToggleGroup$d.e).setTopRightCornerSize(materialButtonToggleGroup$d.c).setBottomRightCornerSize(materialButtonToggleGroup$d.d);
        }
    }

    private boolean updateCheckedStates(int i, boolean z2) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.selectionRequired && checkedButtonIds.isEmpty()) {
            setCheckedStateForView(i, true);
            this.checkedId = i;
            return false;
        }
        if (z2 && this.singleSelection) {
            checkedButtonIds.remove(Integer.valueOf(i));
            Iterator<Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                setCheckedStateForView(iIntValue, false);
                dispatchOnButtonChecked(iIntValue, false);
            }
        }
        return true;
    }

    private void updateChildOrder() {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(getChildButton(i), Integer.valueOf(i));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    public void addOnButtonCheckedListener(@NonNull MaterialButtonToggleGroup$OnButtonCheckedListener materialButtonToggleGroup$OnButtonCheckedListener) {
        this.onButtonCheckedListeners.add(materialButtonToggleGroup$OnButtonCheckedListener);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(LOG_TAG, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, viewGroup$LayoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            updateCheckedStates(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.originalCornerData.add(new MaterialButtonToggleGroup$d(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel.getBottomRightCornerSize()));
        ViewCompat.setAccessibilityDelegate(materialButton, new MaterialButtonToggleGroup$b(this));
    }

    public void check(@IdRes int i) {
        if (i == this.checkedId) {
            return;
        }
        checkForced(i);
    }

    public void clearChecked() {
        this.skipCheckedStateTracker = true;
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton childButton = getChildButton(i);
            childButton.setChecked(false);
            dispatchOnButtonChecked(childButton.getId(), false);
        }
        this.skipCheckedStateTracker = false;
        setCheckedId(-1);
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        updateChildOrder();
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.singleSelection) {
            return this.checkedId;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            MaterialButton childButton = getChildButton(i);
            if (childButton.isChecked()) {
                arrayList.add(Integer.valueOf(childButton.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.childOrder;
        if (numArr != null && i2 < numArr.length) {
            return numArr[i2].intValue();
        }
        Log.w(LOG_TAG, "Child order wasn't updated");
        return i2;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.checkedId;
        if (i != -1) {
            checkForced(i);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat$CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, isSingleSelection() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.removeOnCheckedChangeListener(this.checkedStateTracker);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.originalCornerData.remove(iIndexOfChild);
        }
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public void removeOnButtonCheckedListener(@NonNull MaterialButtonToggleGroup$OnButtonCheckedListener materialButtonToggleGroup$OnButtonCheckedListener) {
        this.onButtonCheckedListeners.remove(materialButtonToggleGroup$OnButtonCheckedListener);
    }

    public void setSelectionRequired(boolean z2) {
        this.selectionRequired = z2;
    }

    public void setSingleSelection(boolean z2) {
        if (this.singleSelection != z2) {
            this.singleSelection = z2;
            clearChecked();
        }
    }

    public void uncheck(@IdRes int i) {
        setCheckedStateForView(i, false);
        updateCheckedStates(i, false);
        this.checkedId = -1;
        dispatchOnButtonChecked(i, false);
    }

    @VisibleForTesting
    public void updateChildShapes() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton childButton = getChildButton(i);
            if (childButton.getVisibility() != 8) {
                ShapeAppearanceModel$Builder builder = childButton.getShapeAppearanceModel().toBuilder();
                updateBuilderWithCornerData(builder, getNewCornerData(i, firstVisibleChildIndex, lastVisibleChildIndex));
                childButton.setShapeAppearanceModel(builder.build());
            }
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        int i2 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.originalCornerData = new ArrayList();
        this.checkedStateTracker = new MaterialButtonToggleGroup$c(this, null);
        this.pressedStateTracker = new MaterialButtonToggleGroup$e(this, null);
        this.onButtonCheckedListeners = new LinkedHashSet<>();
        this.childOrderComparator = new MaterialButtonToggleGroup$a(this);
        this.skipCheckedStateTracker = false;
        TypedArray typedArrayObtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, i, i2, new int[0]);
        setSingleSelection(typedArrayObtainStyledAttributes.getBoolean(R$styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.checkedId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.selectionRequired = typedArrayObtainStyledAttributes.getBoolean(R$styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    public void setSingleSelection(@BoolRes int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
