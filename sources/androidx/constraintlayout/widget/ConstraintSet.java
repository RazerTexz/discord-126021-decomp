package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet {
    private static final int ALPHA = 43;
    private static final int ANIMATE_RELATIVE_TO = 64;
    private static final int BARRIER_ALLOWS_GONE_WIDGETS = 75;
    private static final int BARRIER_DIRECTION = 72;
    private static final int BARRIER_MARGIN = 73;
    private static final int BARRIER_TYPE = 1;
    public static final int BASELINE = 5;
    private static final int BASELINE_TO_BASELINE = 1;
    public static final int BOTTOM = 4;
    private static final int BOTTOM_MARGIN = 2;
    private static final int BOTTOM_TO_BOTTOM = 3;
    private static final int BOTTOM_TO_TOP = 4;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    private static final int CHAIN_USE_RTL = 71;
    private static final int CIRCLE = 61;
    private static final int CIRCLE_ANGLE = 63;
    private static final int CIRCLE_RADIUS = 62;
    private static final int CONSTRAINED_HEIGHT = 81;
    private static final int CONSTRAINED_WIDTH = 80;
    private static final int CONSTRAINT_REFERENCED_IDS = 74;
    private static final int CONSTRAINT_TAG = 77;
    private static final boolean DEBUG = false;
    private static final int DIMENSION_RATIO = 5;
    private static final int DRAW_PATH = 66;
    private static final int EDITOR_ABSOLUTE_X = 6;
    private static final int EDITOR_ABSOLUTE_Y = 7;
    private static final int ELEVATION = 44;
    public static final int END = 7;
    private static final int END_MARGIN = 8;
    private static final int END_TO_END = 9;
    private static final int END_TO_START = 10;
    private static final String ERROR_MESSAGE = "XML parser error must be within a Constraint ";
    public static final int GONE = 8;
    private static final int GONE_BOTTOM_MARGIN = 11;
    private static final int GONE_END_MARGIN = 12;
    private static final int GONE_LEFT_MARGIN = 13;
    private static final int GONE_RIGHT_MARGIN = 14;
    private static final int GONE_START_MARGIN = 15;
    private static final int GONE_TOP_MARGIN = 16;
    private static final int GUIDE_BEGIN = 17;
    private static final int GUIDE_END = 18;
    private static final int GUIDE_PERCENT = 19;
    private static final int HEIGHT_DEFAULT = 55;
    private static final int HEIGHT_MAX = 57;
    private static final int HEIGHT_MIN = 59;
    private static final int HEIGHT_PERCENT = 70;
    public static final int HORIZONTAL = 0;
    private static final int HORIZONTAL_BIAS = 20;
    public static final int HORIZONTAL_GUIDELINE = 0;
    private static final int HORIZONTAL_STYLE = 41;
    private static final int HORIZONTAL_WEIGHT = 39;
    public static final int INVISIBLE = 4;
    private static final int LAYOUT_HEIGHT = 21;
    private static final int LAYOUT_VISIBILITY = 22;
    private static final int LAYOUT_WIDTH = 23;
    public static final int LEFT = 1;
    private static final int LEFT_MARGIN = 24;
    private static final int LEFT_TO_LEFT = 25;
    private static final int LEFT_TO_RIGHT = 26;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    private static final int MOTION_STAGGER = 79;
    private static final int ORIENTATION = 27;
    public static final int PARENT_ID = 0;
    private static final int PATH_MOTION_ARC = 76;
    private static final int PROGRESS = 68;
    public static final int RIGHT = 2;
    private static final int RIGHT_MARGIN = 28;
    private static final int RIGHT_TO_LEFT = 29;
    private static final int RIGHT_TO_RIGHT = 30;
    private static final int ROTATION = 60;
    private static final int ROTATION_X = 45;
    private static final int ROTATION_Y = 46;
    private static final int SCALE_X = 47;
    private static final int SCALE_Y = 48;
    public static final int START = 6;
    private static final int START_MARGIN = 31;
    private static final int START_TO_END = 32;
    private static final int START_TO_START = 33;
    private static final String TAG = "ConstraintSet";
    public static final int TOP = 3;
    private static final int TOP_MARGIN = 34;
    private static final int TOP_TO_BOTTOM = 35;
    private static final int TOP_TO_TOP = 36;
    private static final int TRANSFORM_PIVOT_X = 49;
    private static final int TRANSFORM_PIVOT_Y = 50;
    private static final int TRANSITION_EASING = 65;
    private static final int TRANSITION_PATH_ROTATE = 67;
    private static final int TRANSLATION_X = 51;
    private static final int TRANSLATION_Y = 52;
    private static final int TRANSLATION_Z = 53;
    public static final int UNSET = -1;
    private static final int UNUSED = 82;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_BIAS = 37;
    public static final int VERTICAL_GUIDELINE = 1;
    private static final int VERTICAL_STYLE = 42;
    private static final int VERTICAL_WEIGHT = 40;
    private static final int VIEW_ID = 38;
    private static final int[] VISIBILITY_FLAGS = {0, 4, 8};
    private static final int VISIBILITY_MODE = 78;
    public static final int VISIBILITY_MODE_IGNORE = 1;
    public static final int VISIBILITY_MODE_NORMAL = 0;
    public static final int VISIBLE = 0;
    private static final int WIDTH_DEFAULT = 54;
    private static final int WIDTH_MAX = 56;
    private static final int WIDTH_MIN = 58;
    private static final int WIDTH_PERCENT = 69;
    public static final int WRAP_CONTENT = -2;
    private static SparseIntArray mapToConstant;
    private boolean mValidate;
    private HashMap<String, ConstraintAttribute> mSavedAttributes = new HashMap<>();
    private boolean mForceId = true;
    private HashMap<Integer, ConstraintSet$Constraint> mConstraints = new HashMap<>();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(R$styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        mapToConstant.append(R$styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        mapToConstant.append(R$styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        mapToConstant.append(R$styleable.Constraint_layout_constraintRight_toRightOf, 30);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTop_toTopOf, 36);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        mapToConstant.append(R$styleable.Constraint_layout_editor_absoluteX, 6);
        mapToConstant.append(R$styleable.Constraint_layout_editor_absoluteY, 7);
        mapToConstant.append(R$styleable.Constraint_layout_constraintGuide_begin, 17);
        mapToConstant.append(R$styleable.Constraint_layout_constraintGuide_end, 18);
        mapToConstant.append(R$styleable.Constraint_layout_constraintGuide_percent, 19);
        mapToConstant.append(R$styleable.Constraint_android_orientation, 27);
        mapToConstant.append(R$styleable.Constraint_layout_constraintStart_toEndOf, 32);
        mapToConstant.append(R$styleable.Constraint_layout_constraintStart_toStartOf, 33);
        mapToConstant.append(R$styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        mapToConstant.append(R$styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginLeft, 13);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginTop, 16);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginRight, 14);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginBottom, 11);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginStart, 15);
        mapToConstant.append(R$styleable.Constraint_layout_goneMarginEnd, 12);
        mapToConstant.append(R$styleable.Constraint_layout_constraintVertical_weight, 40);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHorizontal_weight, 39);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        mapToConstant.append(R$styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHorizontal_bias, 20);
        mapToConstant.append(R$styleable.Constraint_layout_constraintVertical_bias, 37);
        mapToConstant.append(R$styleable.Constraint_layout_constraintDimensionRatio, 5);
        mapToConstant.append(R$styleable.Constraint_layout_constraintLeft_creator, 82);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTop_creator, 82);
        mapToConstant.append(R$styleable.Constraint_layout_constraintRight_creator, 82);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBottom_creator, 82);
        mapToConstant.append(R$styleable.Constraint_layout_constraintBaseline_creator, 82);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginLeft, 24);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginRight, 28);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginStart, 31);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginEnd, 8);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginTop, 34);
        mapToConstant.append(R$styleable.Constraint_android_layout_marginBottom, 2);
        mapToConstant.append(R$styleable.Constraint_android_layout_width, 23);
        mapToConstant.append(R$styleable.Constraint_android_layout_height, 21);
        mapToConstant.append(R$styleable.Constraint_android_visibility, 22);
        mapToConstant.append(R$styleable.Constraint_android_alpha, 43);
        mapToConstant.append(R$styleable.Constraint_android_elevation, 44);
        mapToConstant.append(R$styleable.Constraint_android_rotationX, 45);
        mapToConstant.append(R$styleable.Constraint_android_rotationY, 46);
        mapToConstant.append(R$styleable.Constraint_android_rotation, 60);
        mapToConstant.append(R$styleable.Constraint_android_scaleX, 47);
        mapToConstant.append(R$styleable.Constraint_android_scaleY, 48);
        mapToConstant.append(R$styleable.Constraint_android_transformPivotX, 49);
        mapToConstant.append(R$styleable.Constraint_android_transformPivotY, 50);
        mapToConstant.append(R$styleable.Constraint_android_translationX, 51);
        mapToConstant.append(R$styleable.Constraint_android_translationY, 52);
        mapToConstant.append(R$styleable.Constraint_android_translationZ, 53);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_default, 54);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_default, 55);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_max, 56);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_max, 57);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_min, 58);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_min, 59);
        mapToConstant.append(R$styleable.Constraint_layout_constraintCircle, 61);
        mapToConstant.append(R$styleable.Constraint_layout_constraintCircleRadius, 62);
        mapToConstant.append(R$styleable.Constraint_layout_constraintCircleAngle, 63);
        mapToConstant.append(R$styleable.Constraint_animate_relativeTo, 64);
        mapToConstant.append(R$styleable.Constraint_transitionEasing, 65);
        mapToConstant.append(R$styleable.Constraint_drawPath, 66);
        mapToConstant.append(R$styleable.Constraint_transitionPathRotate, 67);
        mapToConstant.append(R$styleable.Constraint_motionStagger, 79);
        mapToConstant.append(R$styleable.Constraint_android_id, 38);
        mapToConstant.append(R$styleable.Constraint_motionProgress, 68);
        mapToConstant.append(R$styleable.Constraint_layout_constraintWidth_percent, 69);
        mapToConstant.append(R$styleable.Constraint_layout_constraintHeight_percent, 70);
        mapToConstant.append(R$styleable.Constraint_chainUseRtl, 71);
        mapToConstant.append(R$styleable.Constraint_barrierDirection, 72);
        mapToConstant.append(R$styleable.Constraint_barrierMargin, 73);
        mapToConstant.append(R$styleable.Constraint_constraint_referenced_ids, 74);
        mapToConstant.append(R$styleable.Constraint_barrierAllowsGoneWidgets, 75);
        mapToConstant.append(R$styleable.Constraint_pathMotionArc, 76);
        mapToConstant.append(R$styleable.Constraint_layout_constraintTag, 77);
        mapToConstant.append(R$styleable.Constraint_visibilityMode, 78);
        mapToConstant.append(R$styleable.Constraint_layout_constrainedWidth, 80);
        mapToConstant.append(R$styleable.Constraint_layout_constrainedHeight, 81);
    }

    public static /* synthetic */ int access$100(TypedArray typedArray, int i, int i2) {
        return lookupID(typedArray, i, i2);
    }

    public static /* synthetic */ int[] access$200() {
        return VISIBILITY_FLAGS;
    }

    private void addAttributes(ConstraintAttribute$AttributeType constraintAttribute$AttributeType, String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (this.mSavedAttributes.containsKey(strArr[i])) {
                ConstraintAttribute constraintAttribute = this.mSavedAttributes.get(strArr[i]);
                if (constraintAttribute.getType() != constraintAttribute$AttributeType) {
                    StringBuilder sbU = a.U("ConstraintAttribute is already a ");
                    sbU.append(constraintAttribute.getType().name());
                    throw new IllegalArgumentException(sbU.toString());
                }
            } else {
                this.mSavedAttributes.put(strArr[i], new ConstraintAttribute(strArr[i], constraintAttribute$AttributeType));
            }
        }
    }

    private int[] convertReferenceString(View view, String str) {
        int iIntValue;
        Object designInformation;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            try {
                iIntValue = R$id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, ModelAuditLogEntry.CHANGE_KEY_ID, context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, strTrim)) != null && (designInformation instanceof Integer)) {
                iIntValue = ((Integer) designInformation).intValue();
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    private ConstraintSet$Constraint fillFromAttributeList(Context context, AttributeSet attributeSet) {
        ConstraintSet$Constraint constraintSet$Constraint = new ConstraintSet$Constraint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Constraint);
        populateConstraint(context, constraintSet$Constraint, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return constraintSet$Constraint;
    }

    private ConstraintSet$Constraint get(int i) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.put(Integer.valueOf(i), new ConstraintSet$Constraint());
        }
        return this.mConstraints.get(Integer.valueOf(i));
    }

    private static int lookupID(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    private void populateConstraint(Context context, ConstraintSet$Constraint constraintSet$Constraint, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index != R$styleable.Constraint_android_id && R$styleable.Constraint_android_layout_marginStart != index && R$styleable.Constraint_android_layout_marginEnd != index) {
                constraintSet$Constraint.motion.mApply = true;
                constraintSet$Constraint.layout.mApply = true;
                constraintSet$Constraint.propertySet.mApply = true;
                constraintSet$Constraint.transform.mApply = true;
            }
            switch (mapToConstant.get(index)) {
                case 1:
                    ConstraintSet$Layout constraintSet$Layout = constraintSet$Constraint.layout;
                    constraintSet$Layout.baselineToBaseline = lookupID(typedArray, index, constraintSet$Layout.baselineToBaseline);
                    break;
                case 2:
                    ConstraintSet$Layout constraintSet$Layout2 = constraintSet$Constraint.layout;
                    constraintSet$Layout2.bottomMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout2.bottomMargin);
                    break;
                case 3:
                    ConstraintSet$Layout constraintSet$Layout3 = constraintSet$Constraint.layout;
                    constraintSet$Layout3.bottomToBottom = lookupID(typedArray, index, constraintSet$Layout3.bottomToBottom);
                    break;
                case 4:
                    ConstraintSet$Layout constraintSet$Layout4 = constraintSet$Constraint.layout;
                    constraintSet$Layout4.bottomToTop = lookupID(typedArray, index, constraintSet$Layout4.bottomToTop);
                    break;
                case 5:
                    constraintSet$Constraint.layout.dimensionRatio = typedArray.getString(index);
                    break;
                case 6:
                    ConstraintSet$Layout constraintSet$Layout5 = constraintSet$Constraint.layout;
                    constraintSet$Layout5.editorAbsoluteX = typedArray.getDimensionPixelOffset(index, constraintSet$Layout5.editorAbsoluteX);
                    break;
                case 7:
                    ConstraintSet$Layout constraintSet$Layout6 = constraintSet$Constraint.layout;
                    constraintSet$Layout6.editorAbsoluteY = typedArray.getDimensionPixelOffset(index, constraintSet$Layout6.editorAbsoluteY);
                    break;
                case 8:
                    ConstraintSet$Layout constraintSet$Layout7 = constraintSet$Constraint.layout;
                    constraintSet$Layout7.endMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout7.endMargin);
                    break;
                case 9:
                    ConstraintSet$Layout constraintSet$Layout8 = constraintSet$Constraint.layout;
                    constraintSet$Layout8.endToEnd = lookupID(typedArray, index, constraintSet$Layout8.endToEnd);
                    break;
                case 10:
                    ConstraintSet$Layout constraintSet$Layout9 = constraintSet$Constraint.layout;
                    constraintSet$Layout9.endToStart = lookupID(typedArray, index, constraintSet$Layout9.endToStart);
                    break;
                case 11:
                    ConstraintSet$Layout constraintSet$Layout10 = constraintSet$Constraint.layout;
                    constraintSet$Layout10.goneBottomMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout10.goneBottomMargin);
                    break;
                case 12:
                    ConstraintSet$Layout constraintSet$Layout11 = constraintSet$Constraint.layout;
                    constraintSet$Layout11.goneEndMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout11.goneEndMargin);
                    break;
                case 13:
                    ConstraintSet$Layout constraintSet$Layout12 = constraintSet$Constraint.layout;
                    constraintSet$Layout12.goneLeftMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout12.goneLeftMargin);
                    break;
                case 14:
                    ConstraintSet$Layout constraintSet$Layout13 = constraintSet$Constraint.layout;
                    constraintSet$Layout13.goneRightMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout13.goneRightMargin);
                    break;
                case 15:
                    ConstraintSet$Layout constraintSet$Layout14 = constraintSet$Constraint.layout;
                    constraintSet$Layout14.goneStartMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout14.goneStartMargin);
                    break;
                case 16:
                    ConstraintSet$Layout constraintSet$Layout15 = constraintSet$Constraint.layout;
                    constraintSet$Layout15.goneTopMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout15.goneTopMargin);
                    break;
                case 17:
                    ConstraintSet$Layout constraintSet$Layout16 = constraintSet$Constraint.layout;
                    constraintSet$Layout16.guideBegin = typedArray.getDimensionPixelOffset(index, constraintSet$Layout16.guideBegin);
                    break;
                case 18:
                    ConstraintSet$Layout constraintSet$Layout17 = constraintSet$Constraint.layout;
                    constraintSet$Layout17.guideEnd = typedArray.getDimensionPixelOffset(index, constraintSet$Layout17.guideEnd);
                    break;
                case 19:
                    ConstraintSet$Layout constraintSet$Layout18 = constraintSet$Constraint.layout;
                    constraintSet$Layout18.guidePercent = typedArray.getFloat(index, constraintSet$Layout18.guidePercent);
                    break;
                case 20:
                    ConstraintSet$Layout constraintSet$Layout19 = constraintSet$Constraint.layout;
                    constraintSet$Layout19.horizontalBias = typedArray.getFloat(index, constraintSet$Layout19.horizontalBias);
                    break;
                case 21:
                    ConstraintSet$Layout constraintSet$Layout20 = constraintSet$Constraint.layout;
                    constraintSet$Layout20.mHeight = typedArray.getLayoutDimension(index, constraintSet$Layout20.mHeight);
                    break;
                case 22:
                    ConstraintSet$PropertySet constraintSet$PropertySet = constraintSet$Constraint.propertySet;
                    constraintSet$PropertySet.visibility = typedArray.getInt(index, constraintSet$PropertySet.visibility);
                    ConstraintSet$PropertySet constraintSet$PropertySet2 = constraintSet$Constraint.propertySet;
                    constraintSet$PropertySet2.visibility = VISIBILITY_FLAGS[constraintSet$PropertySet2.visibility];
                    break;
                case 23:
                    ConstraintSet$Layout constraintSet$Layout21 = constraintSet$Constraint.layout;
                    constraintSet$Layout21.mWidth = typedArray.getLayoutDimension(index, constraintSet$Layout21.mWidth);
                    break;
                case 24:
                    ConstraintSet$Layout constraintSet$Layout22 = constraintSet$Constraint.layout;
                    constraintSet$Layout22.leftMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout22.leftMargin);
                    break;
                case 25:
                    ConstraintSet$Layout constraintSet$Layout23 = constraintSet$Constraint.layout;
                    constraintSet$Layout23.leftToLeft = lookupID(typedArray, index, constraintSet$Layout23.leftToLeft);
                    break;
                case 26:
                    ConstraintSet$Layout constraintSet$Layout24 = constraintSet$Constraint.layout;
                    constraintSet$Layout24.leftToRight = lookupID(typedArray, index, constraintSet$Layout24.leftToRight);
                    break;
                case 27:
                    ConstraintSet$Layout constraintSet$Layout25 = constraintSet$Constraint.layout;
                    constraintSet$Layout25.orientation = typedArray.getInt(index, constraintSet$Layout25.orientation);
                    break;
                case 28:
                    ConstraintSet$Layout constraintSet$Layout26 = constraintSet$Constraint.layout;
                    constraintSet$Layout26.rightMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout26.rightMargin);
                    break;
                case 29:
                    ConstraintSet$Layout constraintSet$Layout27 = constraintSet$Constraint.layout;
                    constraintSet$Layout27.rightToLeft = lookupID(typedArray, index, constraintSet$Layout27.rightToLeft);
                    break;
                case 30:
                    ConstraintSet$Layout constraintSet$Layout28 = constraintSet$Constraint.layout;
                    constraintSet$Layout28.rightToRight = lookupID(typedArray, index, constraintSet$Layout28.rightToRight);
                    break;
                case 31:
                    ConstraintSet$Layout constraintSet$Layout29 = constraintSet$Constraint.layout;
                    constraintSet$Layout29.startMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout29.startMargin);
                    break;
                case 32:
                    ConstraintSet$Layout constraintSet$Layout30 = constraintSet$Constraint.layout;
                    constraintSet$Layout30.startToEnd = lookupID(typedArray, index, constraintSet$Layout30.startToEnd);
                    break;
                case 33:
                    ConstraintSet$Layout constraintSet$Layout31 = constraintSet$Constraint.layout;
                    constraintSet$Layout31.startToStart = lookupID(typedArray, index, constraintSet$Layout31.startToStart);
                    break;
                case 34:
                    ConstraintSet$Layout constraintSet$Layout32 = constraintSet$Constraint.layout;
                    constraintSet$Layout32.topMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout32.topMargin);
                    break;
                case 35:
                    ConstraintSet$Layout constraintSet$Layout33 = constraintSet$Constraint.layout;
                    constraintSet$Layout33.topToBottom = lookupID(typedArray, index, constraintSet$Layout33.topToBottom);
                    break;
                case 36:
                    ConstraintSet$Layout constraintSet$Layout34 = constraintSet$Constraint.layout;
                    constraintSet$Layout34.topToTop = lookupID(typedArray, index, constraintSet$Layout34.topToTop);
                    break;
                case 37:
                    ConstraintSet$Layout constraintSet$Layout35 = constraintSet$Constraint.layout;
                    constraintSet$Layout35.verticalBias = typedArray.getFloat(index, constraintSet$Layout35.verticalBias);
                    break;
                case 38:
                    constraintSet$Constraint.mViewId = typedArray.getResourceId(index, constraintSet$Constraint.mViewId);
                    break;
                case 39:
                    ConstraintSet$Layout constraintSet$Layout36 = constraintSet$Constraint.layout;
                    constraintSet$Layout36.horizontalWeight = typedArray.getFloat(index, constraintSet$Layout36.horizontalWeight);
                    break;
                case 40:
                    ConstraintSet$Layout constraintSet$Layout37 = constraintSet$Constraint.layout;
                    constraintSet$Layout37.verticalWeight = typedArray.getFloat(index, constraintSet$Layout37.verticalWeight);
                    break;
                case 41:
                    ConstraintSet$Layout constraintSet$Layout38 = constraintSet$Constraint.layout;
                    constraintSet$Layout38.horizontalChainStyle = typedArray.getInt(index, constraintSet$Layout38.horizontalChainStyle);
                    break;
                case 42:
                    ConstraintSet$Layout constraintSet$Layout39 = constraintSet$Constraint.layout;
                    constraintSet$Layout39.verticalChainStyle = typedArray.getInt(index, constraintSet$Layout39.verticalChainStyle);
                    break;
                case 43:
                    ConstraintSet$PropertySet constraintSet$PropertySet3 = constraintSet$Constraint.propertySet;
                    constraintSet$PropertySet3.alpha = typedArray.getFloat(index, constraintSet$PropertySet3.alpha);
                    break;
                case 44:
                    ConstraintSet$Transform constraintSet$Transform = constraintSet$Constraint.transform;
                    constraintSet$Transform.applyElevation = true;
                    constraintSet$Transform.elevation = typedArray.getDimension(index, constraintSet$Transform.elevation);
                    break;
                case 45:
                    ConstraintSet$Transform constraintSet$Transform2 = constraintSet$Constraint.transform;
                    constraintSet$Transform2.rotationX = typedArray.getFloat(index, constraintSet$Transform2.rotationX);
                    break;
                case 46:
                    ConstraintSet$Transform constraintSet$Transform3 = constraintSet$Constraint.transform;
                    constraintSet$Transform3.rotationY = typedArray.getFloat(index, constraintSet$Transform3.rotationY);
                    break;
                case 47:
                    ConstraintSet$Transform constraintSet$Transform4 = constraintSet$Constraint.transform;
                    constraintSet$Transform4.scaleX = typedArray.getFloat(index, constraintSet$Transform4.scaleX);
                    break;
                case 48:
                    ConstraintSet$Transform constraintSet$Transform5 = constraintSet$Constraint.transform;
                    constraintSet$Transform5.scaleY = typedArray.getFloat(index, constraintSet$Transform5.scaleY);
                    break;
                case 49:
                    ConstraintSet$Transform constraintSet$Transform6 = constraintSet$Constraint.transform;
                    constraintSet$Transform6.transformPivotX = typedArray.getDimension(index, constraintSet$Transform6.transformPivotX);
                    break;
                case 50:
                    ConstraintSet$Transform constraintSet$Transform7 = constraintSet$Constraint.transform;
                    constraintSet$Transform7.transformPivotY = typedArray.getDimension(index, constraintSet$Transform7.transformPivotY);
                    break;
                case 51:
                    ConstraintSet$Transform constraintSet$Transform8 = constraintSet$Constraint.transform;
                    constraintSet$Transform8.translationX = typedArray.getDimension(index, constraintSet$Transform8.translationX);
                    break;
                case 52:
                    ConstraintSet$Transform constraintSet$Transform9 = constraintSet$Constraint.transform;
                    constraintSet$Transform9.translationY = typedArray.getDimension(index, constraintSet$Transform9.translationY);
                    break;
                case 53:
                    ConstraintSet$Transform constraintSet$Transform10 = constraintSet$Constraint.transform;
                    constraintSet$Transform10.translationZ = typedArray.getDimension(index, constraintSet$Transform10.translationZ);
                    break;
                case 54:
                    ConstraintSet$Layout constraintSet$Layout40 = constraintSet$Constraint.layout;
                    constraintSet$Layout40.widthDefault = typedArray.getInt(index, constraintSet$Layout40.widthDefault);
                    break;
                case 55:
                    ConstraintSet$Layout constraintSet$Layout41 = constraintSet$Constraint.layout;
                    constraintSet$Layout41.heightDefault = typedArray.getInt(index, constraintSet$Layout41.heightDefault);
                    break;
                case 56:
                    ConstraintSet$Layout constraintSet$Layout42 = constraintSet$Constraint.layout;
                    constraintSet$Layout42.widthMax = typedArray.getDimensionPixelSize(index, constraintSet$Layout42.widthMax);
                    break;
                case 57:
                    ConstraintSet$Layout constraintSet$Layout43 = constraintSet$Constraint.layout;
                    constraintSet$Layout43.heightMax = typedArray.getDimensionPixelSize(index, constraintSet$Layout43.heightMax);
                    break;
                case 58:
                    ConstraintSet$Layout constraintSet$Layout44 = constraintSet$Constraint.layout;
                    constraintSet$Layout44.widthMin = typedArray.getDimensionPixelSize(index, constraintSet$Layout44.widthMin);
                    break;
                case 59:
                    ConstraintSet$Layout constraintSet$Layout45 = constraintSet$Constraint.layout;
                    constraintSet$Layout45.heightMin = typedArray.getDimensionPixelSize(index, constraintSet$Layout45.heightMin);
                    break;
                case 60:
                    ConstraintSet$Transform constraintSet$Transform11 = constraintSet$Constraint.transform;
                    constraintSet$Transform11.rotation = typedArray.getFloat(index, constraintSet$Transform11.rotation);
                    break;
                case 61:
                    ConstraintSet$Layout constraintSet$Layout46 = constraintSet$Constraint.layout;
                    constraintSet$Layout46.circleConstraint = lookupID(typedArray, index, constraintSet$Layout46.circleConstraint);
                    break;
                case 62:
                    ConstraintSet$Layout constraintSet$Layout47 = constraintSet$Constraint.layout;
                    constraintSet$Layout47.circleRadius = typedArray.getDimensionPixelSize(index, constraintSet$Layout47.circleRadius);
                    break;
                case 63:
                    ConstraintSet$Layout constraintSet$Layout48 = constraintSet$Constraint.layout;
                    constraintSet$Layout48.circleAngle = typedArray.getFloat(index, constraintSet$Layout48.circleAngle);
                    break;
                case 64:
                    ConstraintSet$Motion constraintSet$Motion = constraintSet$Constraint.motion;
                    constraintSet$Motion.mAnimateRelativeTo = lookupID(typedArray, index, constraintSet$Motion.mAnimateRelativeTo);
                    break;
                case 65:
                    if (typedArray.peekValue(index).type == 3) {
                        constraintSet$Constraint.motion.mTransitionEasing = typedArray.getString(index);
                    } else {
                        constraintSet$Constraint.motion.mTransitionEasing = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    constraintSet$Constraint.motion.mDrawPath = typedArray.getInt(index, 0);
                    break;
                case 67:
                    ConstraintSet$Motion constraintSet$Motion2 = constraintSet$Constraint.motion;
                    constraintSet$Motion2.mPathRotate = typedArray.getFloat(index, constraintSet$Motion2.mPathRotate);
                    break;
                case 68:
                    ConstraintSet$PropertySet constraintSet$PropertySet4 = constraintSet$Constraint.propertySet;
                    constraintSet$PropertySet4.mProgress = typedArray.getFloat(index, constraintSet$PropertySet4.mProgress);
                    break;
                case 69:
                    constraintSet$Constraint.layout.widthPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 70:
                    constraintSet$Constraint.layout.heightPercent = typedArray.getFloat(index, 1.0f);
                    break;
                case 71:
                    Log.e(TAG, "CURRENTLY UNSUPPORTED");
                    break;
                case 72:
                    ConstraintSet$Layout constraintSet$Layout49 = constraintSet$Constraint.layout;
                    constraintSet$Layout49.mBarrierDirection = typedArray.getInt(index, constraintSet$Layout49.mBarrierDirection);
                    break;
                case 73:
                    ConstraintSet$Layout constraintSet$Layout50 = constraintSet$Constraint.layout;
                    constraintSet$Layout50.mBarrierMargin = typedArray.getDimensionPixelSize(index, constraintSet$Layout50.mBarrierMargin);
                    break;
                case 74:
                    constraintSet$Constraint.layout.mReferenceIdString = typedArray.getString(index);
                    break;
                case 75:
                    ConstraintSet$Layout constraintSet$Layout51 = constraintSet$Constraint.layout;
                    constraintSet$Layout51.mBarrierAllowsGoneWidgets = typedArray.getBoolean(index, constraintSet$Layout51.mBarrierAllowsGoneWidgets);
                    break;
                case 76:
                    ConstraintSet$Motion constraintSet$Motion3 = constraintSet$Constraint.motion;
                    constraintSet$Motion3.mPathMotionArc = typedArray.getInt(index, constraintSet$Motion3.mPathMotionArc);
                    break;
                case 77:
                    constraintSet$Constraint.layout.mConstraintTag = typedArray.getString(index);
                    break;
                case 78:
                    ConstraintSet$PropertySet constraintSet$PropertySet5 = constraintSet$Constraint.propertySet;
                    constraintSet$PropertySet5.mVisibilityMode = typedArray.getInt(index, constraintSet$PropertySet5.mVisibilityMode);
                    break;
                case 79:
                    ConstraintSet$Motion constraintSet$Motion4 = constraintSet$Constraint.motion;
                    constraintSet$Motion4.mMotionStagger = typedArray.getFloat(index, constraintSet$Motion4.mMotionStagger);
                    break;
                case 80:
                    ConstraintSet$Layout constraintSet$Layout52 = constraintSet$Constraint.layout;
                    constraintSet$Layout52.constrainedWidth = typedArray.getBoolean(index, constraintSet$Layout52.constrainedWidth);
                    break;
                case 81:
                    ConstraintSet$Layout constraintSet$Layout53 = constraintSet$Constraint.layout;
                    constraintSet$Layout53.constrainedHeight = typedArray.getBoolean(index, constraintSet$Layout53.constrainedHeight);
                    break;
                case 82:
                    StringBuilder sbU = a.U("unused attribute 0x");
                    sbU.append(Integer.toHexString(index));
                    sbU.append("   ");
                    sbU.append(mapToConstant.get(index));
                    Log.w(TAG, sbU.toString());
                    break;
                default:
                    StringBuilder sbU2 = a.U("Unknown attribute 0x");
                    sbU2.append(Integer.toHexString(index));
                    sbU2.append("   ");
                    sbU2.append(mapToConstant.get(index));
                    Log.w(TAG, sbU2.toString());
                    break;
            }
        }
    }

    private String sideToString(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    private static String[] splitString(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z2 = false;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] == ',' && !z2) {
                arrayList.add(new String(charArray, i, i2 - i));
                i = i2 + 1;
            } else if (charArray[i2] == '\"') {
                z2 = !z2;
            }
        }
        arrayList.add(new String(charArray, i, charArray.length - i));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void addColorAttributes(String... strArr) {
        addAttributes(ConstraintAttribute$AttributeType.COLOR_TYPE, strArr);
    }

    public void addFloatAttributes(String... strArr) {
        addAttributes(ConstraintAttribute$AttributeType.FLOAT_TYPE, strArr);
    }

    public void addIntAttributes(String... strArr) {
        addAttributes(ConstraintAttribute$AttributeType.INT_TYPE, strArr);
    }

    public void addStringAttributes(String... strArr) {
        addAttributes(ConstraintAttribute$AttributeType.STRING_TYPE, strArr);
    }

    public void addToHorizontalChain(int i, int i2, int i3) {
        connect(i, 1, i2, i2 == 0 ? 1 : 2, 0);
        connect(i, 2, i3, i3 == 0 ? 2 : 1, 0);
        if (i2 != 0) {
            connect(i2, 2, i, 1, 0);
        }
        if (i3 != 0) {
            connect(i3, 1, i, 2, 0);
        }
    }

    public void addToHorizontalChainRTL(int i, int i2, int i3) {
        connect(i, 6, i2, i2 == 0 ? 6 : 7, 0);
        connect(i, 7, i3, i3 == 0 ? 7 : 6, 0);
        if (i2 != 0) {
            connect(i2, 7, i, 6, 0);
        }
        if (i3 != 0) {
            connect(i3, 6, i, 7, 0);
        }
    }

    public void addToVerticalChain(int i, int i2, int i3) {
        connect(i, 3, i2, i2 == 0 ? 3 : 4, 0);
        connect(i, 4, i3, i3 == 0 ? 4 : 3, 0);
        if (i2 != 0) {
            connect(i2, 4, i, 3, 0);
        }
        if (i3 != 0) {
            connect(i3, 3, i, 4, 0);
        }
    }

    public void applyCustomAttributes(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id2 = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                StringBuilder sbU = a.U("id unknown ");
                sbU.append(Debug.getName(childAt));
                Log.v(TAG, sbU.toString());
            } else {
                if (this.mForceId && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.mConstraints.containsKey(Integer.valueOf(id2))) {
                    ConstraintAttribute.setAttributes(childAt, this.mConstraints.get(Integer.valueOf(id2)).mCustomConstraints);
                }
            }
        }
    }

    public void applyTo(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public void applyToHelper(ConstraintHelper constraintHelper, ConstraintWidget constraintWidget, ConstraintLayout$LayoutParams constraintLayout$LayoutParams, SparseArray<ConstraintWidget> sparseArray) {
        int id2 = constraintHelper.getId();
        if (this.mConstraints.containsKey(Integer.valueOf(id2))) {
            ConstraintSet$Constraint constraintSet$Constraint = this.mConstraints.get(Integer.valueOf(id2));
            if (constraintWidget instanceof HelperWidget) {
                constraintHelper.loadParameters(constraintSet$Constraint, (HelperWidget) constraintWidget, constraintLayout$LayoutParams, sparseArray);
            }
        }
    }

    public void applyToInternal(ConstraintLayout constraintLayout, boolean z2) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.mConstraints.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id2 = childAt.getId();
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                StringBuilder sbU = a.U("id unknown ");
                sbU.append(Debug.getName(childAt));
                Log.w(TAG, sbU.toString());
            } else {
                if (this.mForceId && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (this.mConstraints.containsKey(Integer.valueOf(id2))) {
                        hashSet.remove(Integer.valueOf(id2));
                        ConstraintSet$Constraint constraintSet$Constraint = this.mConstraints.get(Integer.valueOf(id2));
                        if (childAt instanceof Barrier) {
                            constraintSet$Constraint.layout.mHelperType = 1;
                        }
                        int i2 = constraintSet$Constraint.layout.mHelperType;
                        if (i2 != -1 && i2 == 1) {
                            Barrier barrier = (Barrier) childAt;
                            barrier.setId(id2);
                            barrier.setType(constraintSet$Constraint.layout.mBarrierDirection);
                            barrier.setMargin(constraintSet$Constraint.layout.mBarrierMargin);
                            barrier.setAllowsGoneWidget(constraintSet$Constraint.layout.mBarrierAllowsGoneWidgets);
                            ConstraintSet$Layout constraintSet$Layout = constraintSet$Constraint.layout;
                            int[] iArr = constraintSet$Layout.mReferenceIds;
                            if (iArr != null) {
                                barrier.setReferencedIds(iArr);
                            } else {
                                String str = constraintSet$Layout.mReferenceIdString;
                                if (str != null) {
                                    constraintSet$Layout.mReferenceIds = convertReferenceString(barrier, str);
                                    barrier.setReferencedIds(constraintSet$Constraint.layout.mReferenceIds);
                                }
                            }
                        }
                        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) childAt.getLayoutParams();
                        constraintLayout$LayoutParams.validate();
                        constraintSet$Constraint.applyTo(constraintLayout$LayoutParams);
                        if (z2) {
                            ConstraintAttribute.setAttributes(childAt, constraintSet$Constraint.mCustomConstraints);
                        }
                        childAt.setLayoutParams(constraintLayout$LayoutParams);
                        ConstraintSet$PropertySet constraintSet$PropertySet = constraintSet$Constraint.propertySet;
                        if (constraintSet$PropertySet.mVisibilityMode == 0) {
                            childAt.setVisibility(constraintSet$PropertySet.visibility);
                        }
                        childAt.setAlpha(constraintSet$Constraint.propertySet.alpha);
                        childAt.setRotation(constraintSet$Constraint.transform.rotation);
                        childAt.setRotationX(constraintSet$Constraint.transform.rotationX);
                        childAt.setRotationY(constraintSet$Constraint.transform.rotationY);
                        childAt.setScaleX(constraintSet$Constraint.transform.scaleX);
                        childAt.setScaleY(constraintSet$Constraint.transform.scaleY);
                        if (!Float.isNaN(constraintSet$Constraint.transform.transformPivotX)) {
                            childAt.setPivotX(constraintSet$Constraint.transform.transformPivotX);
                        }
                        if (!Float.isNaN(constraintSet$Constraint.transform.transformPivotY)) {
                            childAt.setPivotY(constraintSet$Constraint.transform.transformPivotY);
                        }
                        childAt.setTranslationX(constraintSet$Constraint.transform.translationX);
                        childAt.setTranslationY(constraintSet$Constraint.transform.translationY);
                        childAt.setTranslationZ(constraintSet$Constraint.transform.translationZ);
                        ConstraintSet$Transform constraintSet$Transform = constraintSet$Constraint.transform;
                        if (constraintSet$Transform.applyElevation) {
                            childAt.setElevation(constraintSet$Transform.elevation);
                        }
                    } else {
                        Log.v(TAG, "WARNING NO CONSTRAINTS for view " + id2);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            ConstraintSet$Constraint constraintSet$Constraint2 = this.mConstraints.get(num);
            int i3 = constraintSet$Constraint2.layout.mHelperType;
            if (i3 != -1 && i3 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                ConstraintSet$Layout constraintSet$Layout2 = constraintSet$Constraint2.layout;
                int[] iArr2 = constraintSet$Layout2.mReferenceIds;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = constraintSet$Layout2.mReferenceIdString;
                    if (str2 != null) {
                        constraintSet$Layout2.mReferenceIds = convertReferenceString(barrier2, str2);
                        barrier2.setReferencedIds(constraintSet$Constraint2.layout.mReferenceIds);
                    }
                }
                barrier2.setType(constraintSet$Constraint2.layout.mBarrierDirection);
                barrier2.setMargin(constraintSet$Constraint2.layout.mBarrierMargin);
                ConstraintLayout$LayoutParams constraintLayout$LayoutParamsGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.validateParams();
                constraintSet$Constraint2.applyTo(constraintLayout$LayoutParamsGenerateDefaultLayoutParams);
                constraintLayout.addView(barrier2, constraintLayout$LayoutParamsGenerateDefaultLayoutParams);
            }
            if (constraintSet$Constraint2.layout.mIsGuideline) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout$LayoutParams constraintLayout$LayoutParamsGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                constraintSet$Constraint2.applyTo(constraintLayout$LayoutParamsGenerateDefaultLayoutParams2);
                constraintLayout.addView(guideline, constraintLayout$LayoutParamsGenerateDefaultLayoutParams2);
            }
        }
    }

    public void applyToLayoutParams(int i, ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.get(Integer.valueOf(i)).applyTo(constraintLayout$LayoutParams);
        }
    }

    public void applyToWithoutCustom(ConstraintLayout constraintLayout) {
        applyToInternal(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public void center(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        if (i4 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (i7 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (f <= 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (i3 == 1 || i3 == 2) {
            connect(i, 1, i2, i3, i4);
            connect(i, 2, i5, i6, i7);
            this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
        } else if (i3 == 6 || i3 == 7) {
            connect(i, 6, i2, i3, i4);
            connect(i, 7, i5, i6, i7);
            this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
        } else {
            connect(i, 3, i2, i3, i4);
            connect(i, 4, i5, i6, i7);
            this.mConstraints.get(Integer.valueOf(i)).layout.verticalBias = f;
        }
    }

    public void centerHorizontally(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 1, i2, i3, i4);
        connect(i, 2, i5, i6, i7);
        this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
    }

    public void centerHorizontallyRtl(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 6, i2, i3, i4);
        connect(i, 7, i5, i6, i7);
        this.mConstraints.get(Integer.valueOf(i)).layout.horizontalBias = f;
    }

    public void centerVertically(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f) {
        connect(i, 3, i2, i3, i4);
        connect(i, 4, i5, i6, i7);
        this.mConstraints.get(Integer.valueOf(i)).layout.verticalBias = f;
    }

    public void clear(int i) {
        this.mConstraints.remove(Integer.valueOf(i));
    }

    public void clone(Context context, int i) {
        clone((ConstraintLayout) LayoutInflater.from(context).inflate(i, (ViewGroup) null));
    }

    public void connect(int i, int i2, int i3, int i4, int i5) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.put(Integer.valueOf(i), new ConstraintSet$Constraint());
        }
        ConstraintSet$Constraint constraintSet$Constraint = this.mConstraints.get(Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    ConstraintSet$Layout constraintSet$Layout = constraintSet$Constraint.layout;
                    constraintSet$Layout.leftToLeft = i3;
                    constraintSet$Layout.leftToRight = -1;
                } else {
                    if (i4 != 2) {
                        throw new IllegalArgumentException(a.J(a.U("Left to "), sideToString(i4), " undefined"));
                    }
                    ConstraintSet$Layout constraintSet$Layout2 = constraintSet$Constraint.layout;
                    constraintSet$Layout2.leftToRight = i3;
                    constraintSet$Layout2.leftToLeft = -1;
                }
                constraintSet$Constraint.layout.leftMargin = i5;
                return;
            case 2:
                if (i4 == 1) {
                    ConstraintSet$Layout constraintSet$Layout3 = constraintSet$Constraint.layout;
                    constraintSet$Layout3.rightToLeft = i3;
                    constraintSet$Layout3.rightToRight = -1;
                } else {
                    if (i4 != 2) {
                        throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
                    }
                    ConstraintSet$Layout constraintSet$Layout4 = constraintSet$Constraint.layout;
                    constraintSet$Layout4.rightToRight = i3;
                    constraintSet$Layout4.rightToLeft = -1;
                }
                constraintSet$Constraint.layout.rightMargin = i5;
                return;
            case 3:
                if (i4 == 3) {
                    ConstraintSet$Layout constraintSet$Layout5 = constraintSet$Constraint.layout;
                    constraintSet$Layout5.topToTop = i3;
                    constraintSet$Layout5.topToBottom = -1;
                    constraintSet$Layout5.baselineToBaseline = -1;
                } else {
                    if (i4 != 4) {
                        throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
                    }
                    ConstraintSet$Layout constraintSet$Layout6 = constraintSet$Constraint.layout;
                    constraintSet$Layout6.topToBottom = i3;
                    constraintSet$Layout6.topToTop = -1;
                    constraintSet$Layout6.baselineToBaseline = -1;
                }
                constraintSet$Constraint.layout.topMargin = i5;
                return;
            case 4:
                if (i4 == 4) {
                    ConstraintSet$Layout constraintSet$Layout7 = constraintSet$Constraint.layout;
                    constraintSet$Layout7.bottomToBottom = i3;
                    constraintSet$Layout7.bottomToTop = -1;
                    constraintSet$Layout7.baselineToBaseline = -1;
                } else {
                    if (i4 != 3) {
                        throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
                    }
                    ConstraintSet$Layout constraintSet$Layout8 = constraintSet$Constraint.layout;
                    constraintSet$Layout8.bottomToTop = i3;
                    constraintSet$Layout8.bottomToBottom = -1;
                    constraintSet$Layout8.baselineToBaseline = -1;
                }
                constraintSet$Constraint.layout.bottomMargin = i5;
                return;
            case 5:
                if (i4 != 5) {
                    throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
                }
                ConstraintSet$Layout constraintSet$Layout9 = constraintSet$Constraint.layout;
                constraintSet$Layout9.baselineToBaseline = i3;
                constraintSet$Layout9.bottomToBottom = -1;
                constraintSet$Layout9.bottomToTop = -1;
                constraintSet$Layout9.topToTop = -1;
                constraintSet$Layout9.topToBottom = -1;
                return;
            case 6:
                if (i4 == 6) {
                    ConstraintSet$Layout constraintSet$Layout10 = constraintSet$Constraint.layout;
                    constraintSet$Layout10.startToStart = i3;
                    constraintSet$Layout10.startToEnd = -1;
                } else {
                    if (i4 != 7) {
                        throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
                    }
                    ConstraintSet$Layout constraintSet$Layout11 = constraintSet$Constraint.layout;
                    constraintSet$Layout11.startToEnd = i3;
                    constraintSet$Layout11.startToStart = -1;
                }
                constraintSet$Constraint.layout.startMargin = i5;
                return;
            case 7:
                if (i4 == 7) {
                    ConstraintSet$Layout constraintSet$Layout12 = constraintSet$Constraint.layout;
                    constraintSet$Layout12.endToEnd = i3;
                    constraintSet$Layout12.endToStart = -1;
                } else {
                    if (i4 != 6) {
                        throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
                    }
                    ConstraintSet$Layout constraintSet$Layout13 = constraintSet$Constraint.layout;
                    constraintSet$Layout13.endToStart = i3;
                    constraintSet$Layout13.endToEnd = -1;
                }
                constraintSet$Constraint.layout.endMargin = i5;
                return;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append(sideToString(i2));
                sb.append(" to ");
                throw new IllegalArgumentException(a.J(sb, sideToString(i4), " unknown"));
        }
    }

    public void constrainCircle(int i, int i2, int i3, float f) {
        ConstraintSet$Layout constraintSet$Layout = get(i).layout;
        constraintSet$Layout.circleConstraint = i2;
        constraintSet$Layout.circleRadius = i3;
        constraintSet$Layout.circleAngle = f;
    }

    public void constrainDefaultHeight(int i, int i2) {
        get(i).layout.heightDefault = i2;
    }

    public void constrainDefaultWidth(int i, int i2) {
        get(i).layout.widthDefault = i2;
    }

    public void constrainHeight(int i, int i2) {
        get(i).layout.mHeight = i2;
    }

    public void constrainMaxHeight(int i, int i2) {
        get(i).layout.heightMax = i2;
    }

    public void constrainMaxWidth(int i, int i2) {
        get(i).layout.widthMax = i2;
    }

    public void constrainMinHeight(int i, int i2) {
        get(i).layout.heightMin = i2;
    }

    public void constrainMinWidth(int i, int i2) {
        get(i).layout.widthMin = i2;
    }

    public void constrainPercentHeight(int i, float f) {
        get(i).layout.heightPercent = f;
    }

    public void constrainPercentWidth(int i, float f) {
        get(i).layout.widthPercent = f;
    }

    public void constrainWidth(int i, int i2) {
        get(i).layout.mWidth = i2;
    }

    public void constrainedHeight(int i, boolean z2) {
        get(i).layout.constrainedHeight = z2;
    }

    public void constrainedWidth(int i, boolean z2) {
        get(i).layout.constrainedWidth = z2;
    }

    public void create(int i, int i2) {
        ConstraintSet$Layout constraintSet$Layout = get(i).layout;
        constraintSet$Layout.mIsGuideline = true;
        constraintSet$Layout.orientation = i2;
    }

    public void createBarrier(int i, int i2, int i3, int... iArr) {
        ConstraintSet$Layout constraintSet$Layout = get(i).layout;
        constraintSet$Layout.mHelperType = 1;
        constraintSet$Layout.mBarrierDirection = i2;
        constraintSet$Layout.mBarrierMargin = i3;
        constraintSet$Layout.mIsGuideline = false;
        constraintSet$Layout.mReferenceIds = iArr;
    }

    public void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        createHorizontalChain(i, i2, i3, i4, iArr, fArr, i5, 1, 2);
    }

    public void createHorizontalChainRtl(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        createHorizontalChain(i, i2, i3, i4, iArr, fArr, i5, 6, 7);
    }

    public void createVerticalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            get(iArr[0]).layout.verticalWeight = fArr[0];
        }
        get(iArr[0]).layout.verticalChainStyle = i5;
        connect(iArr[0], 3, i, i2, 0);
        for (int i6 = 1; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            int i8 = i6 - 1;
            connect(iArr[i6], 3, iArr[i8], 4, 0);
            connect(iArr[i8], 4, iArr[i6], 3, 0);
            if (fArr != null) {
                get(iArr[i6]).layout.verticalWeight = fArr[i6];
            }
        }
        connect(iArr[iArr.length - 1], 4, i3, i4, 0);
    }

    public void dump(MotionScene motionScene, int... iArr) {
        HashSet hashSet;
        Set<Integer> setKeySet = this.mConstraints.keySet();
        if (iArr.length != 0) {
            hashSet = new HashSet();
            for (int i : iArr) {
                hashSet.add(Integer.valueOf(i));
            }
        } else {
            hashSet = new HashSet(setKeySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            ConstraintSet$Constraint constraintSet$Constraint = this.mConstraints.get(num);
            sb.append("<Constraint id=");
            sb.append(num);
            sb.append(" \n");
            constraintSet$Constraint.layout.dump(motionScene, sb);
            sb.append("/>\n");
        }
        System.out.println(sb.toString());
    }

    public boolean getApplyElevation(int i) {
        return get(i).transform.applyElevation;
    }

    public ConstraintSet$Constraint getConstraint(int i) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            return this.mConstraints.get(Integer.valueOf(i));
        }
        return null;
    }

    public HashMap<String, ConstraintAttribute> getCustomAttributeSet() {
        return this.mSavedAttributes;
    }

    public int getHeight(int i) {
        return get(i).layout.mHeight;
    }

    public int[] getKnownIds() {
        Integer[] numArr = (Integer[]) this.mConstraints.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public ConstraintSet$Constraint getParameters(int i) {
        return get(i);
    }

    public int[] getReferencedIds(int i) {
        int[] iArr = get(i).layout.mReferenceIds;
        return iArr == null ? new int[0] : Arrays.copyOf(iArr, iArr.length);
    }

    public int getVisibility(int i) {
        return get(i).propertySet.visibility;
    }

    public int getVisibilityMode(int i) {
        return get(i).propertySet.mVisibilityMode;
    }

    public int getWidth(int i) {
        return get(i).layout.mWidth;
    }

    public boolean isForceId() {
        return this.mForceId;
    }

    public void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    ConstraintSet$Constraint constraintSet$ConstraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        constraintSet$ConstraintFillFromAttributeList.layout.mIsGuideline = true;
                    }
                    this.mConstraints.put(Integer.valueOf(constraintSet$ConstraintFillFromAttributeList.mViewId), constraintSet$ConstraintFillFromAttributeList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public void parseColorAttributes(ConstraintSet$Constraint constraintSet$Constraint, String str) {
        String[] strArrSplit = str.split(",");
        for (int i = 0; i < strArrSplit.length; i++) {
            String[] strArrSplit2 = strArrSplit[i].split("=");
            if (strArrSplit2.length != 2) {
                a.r0(a.U(" Unable to parse "), strArrSplit[i], TAG);
            } else {
                ConstraintSet$Constraint.access$600(constraintSet$Constraint, strArrSplit2[0], Color.parseColor(strArrSplit2[1]));
            }
        }
    }

    public void parseFloatAttributes(ConstraintSet$Constraint constraintSet$Constraint, String str) {
        String[] strArrSplit = str.split(",");
        for (int i = 0; i < strArrSplit.length; i++) {
            String[] strArrSplit2 = strArrSplit[i].split("=");
            if (strArrSplit2.length != 2) {
                a.r0(a.U(" Unable to parse "), strArrSplit[i], TAG);
            } else {
                ConstraintSet$Constraint.access$700(constraintSet$Constraint, strArrSplit2[0], Float.parseFloat(strArrSplit2[1]));
            }
        }
    }

    public void parseIntAttributes(ConstraintSet$Constraint constraintSet$Constraint, String str) {
        String[] strArrSplit = str.split(",");
        for (int i = 0; i < strArrSplit.length; i++) {
            String[] strArrSplit2 = strArrSplit[i].split("=");
            if (strArrSplit2.length != 2) {
                a.r0(a.U(" Unable to parse "), strArrSplit[i], TAG);
            } else {
                ConstraintSet$Constraint.access$700(constraintSet$Constraint, strArrSplit2[0], Integer.decode(strArrSplit2[1]).intValue());
            }
        }
    }

    public void parseStringAttributes(ConstraintSet$Constraint constraintSet$Constraint, String str) {
        String[] strArrSplitString = splitString(str);
        for (int i = 0; i < strArrSplitString.length; i++) {
            String[] strArrSplit = strArrSplitString[i].split("=");
            a.r0(a.U(" Unable to parse "), strArrSplitString[i], TAG);
            ConstraintSet$Constraint.access$800(constraintSet$Constraint, strArrSplit[0], strArrSplit[1]);
        }
    }

    public void readFallback(ConstraintSet constraintSet) {
        for (Integer num : constraintSet.mConstraints.keySet()) {
            int iIntValue = num.intValue();
            ConstraintSet$Constraint constraintSet$Constraint = constraintSet.mConstraints.get(num);
            if (!this.mConstraints.containsKey(Integer.valueOf(iIntValue))) {
                this.mConstraints.put(Integer.valueOf(iIntValue), new ConstraintSet$Constraint());
            }
            ConstraintSet$Constraint constraintSet$Constraint2 = this.mConstraints.get(Integer.valueOf(iIntValue));
            ConstraintSet$Layout constraintSet$Layout = constraintSet$Constraint2.layout;
            if (!constraintSet$Layout.mApply) {
                constraintSet$Layout.copyFrom(constraintSet$Constraint.layout);
            }
            ConstraintSet$PropertySet constraintSet$PropertySet = constraintSet$Constraint2.propertySet;
            if (!constraintSet$PropertySet.mApply) {
                constraintSet$PropertySet.copyFrom(constraintSet$Constraint.propertySet);
            }
            ConstraintSet$Transform constraintSet$Transform = constraintSet$Constraint2.transform;
            if (!constraintSet$Transform.mApply) {
                constraintSet$Transform.copyFrom(constraintSet$Constraint.transform);
            }
            ConstraintSet$Motion constraintSet$Motion = constraintSet$Constraint2.motion;
            if (!constraintSet$Motion.mApply) {
                constraintSet$Motion.copyFrom(constraintSet$Constraint.motion);
            }
            for (String str : constraintSet$Constraint.mCustomConstraints.keySet()) {
                if (!constraintSet$Constraint2.mCustomConstraints.containsKey(str)) {
                    constraintSet$Constraint2.mCustomConstraints.put(str, constraintSet$Constraint.mCustomConstraints.get(str));
                }
            }
        }
    }

    public void removeAttribute(String str) {
        this.mSavedAttributes.remove(str);
    }

    public void removeFromHorizontalChain(int i) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            ConstraintSet$Layout constraintSet$Layout = this.mConstraints.get(Integer.valueOf(i)).layout;
            int i2 = constraintSet$Layout.leftToRight;
            int i3 = constraintSet$Layout.rightToLeft;
            if (i2 != -1 || i3 != -1) {
                if (i2 != -1 && i3 != -1) {
                    connect(i2, 2, i3, 1, 0);
                    connect(i3, 1, i2, 2, 0);
                } else if (i2 != -1 || i3 != -1) {
                    int i4 = constraintSet$Layout.rightToRight;
                    if (i4 != -1) {
                        connect(i2, 2, i4, 2, 0);
                    } else {
                        int i5 = constraintSet$Layout.leftToLeft;
                        if (i5 != -1) {
                            connect(i3, 1, i5, 1, 0);
                        }
                    }
                }
                clear(i, 1);
                clear(i, 2);
                return;
            }
            int i6 = constraintSet$Layout.startToEnd;
            int i7 = constraintSet$Layout.endToStart;
            if (i6 != -1 || i7 != -1) {
                if (i6 != -1 && i7 != -1) {
                    connect(i6, 7, i7, 6, 0);
                    connect(i7, 6, i2, 7, 0);
                } else if (i2 != -1 || i7 != -1) {
                    int i8 = constraintSet$Layout.rightToRight;
                    if (i8 != -1) {
                        connect(i2, 7, i8, 7, 0);
                    } else {
                        int i9 = constraintSet$Layout.leftToLeft;
                        if (i9 != -1) {
                            connect(i7, 6, i9, 6, 0);
                        }
                    }
                }
            }
            clear(i, 6);
            clear(i, 7);
        }
    }

    public void removeFromVerticalChain(int i) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            ConstraintSet$Layout constraintSet$Layout = this.mConstraints.get(Integer.valueOf(i)).layout;
            int i2 = constraintSet$Layout.topToBottom;
            int i3 = constraintSet$Layout.bottomToTop;
            if (i2 != -1 || i3 != -1) {
                if (i2 != -1 && i3 != -1) {
                    connect(i2, 4, i3, 3, 0);
                    connect(i3, 3, i2, 4, 0);
                } else if (i2 != -1 || i3 != -1) {
                    int i4 = constraintSet$Layout.bottomToBottom;
                    if (i4 != -1) {
                        connect(i2, 4, i4, 4, 0);
                    } else {
                        int i5 = constraintSet$Layout.topToTop;
                        if (i5 != -1) {
                            connect(i3, 3, i5, 3, 0);
                        }
                    }
                }
            }
        }
        clear(i, 3);
        clear(i, 4);
    }

    public void setAlpha(int i, float f) {
        get(i).propertySet.alpha = f;
    }

    public void setApplyElevation(int i, boolean z2) {
        get(i).transform.applyElevation = z2;
    }

    public void setBarrierType(int i, int i2) {
        get(i).layout.mHelperType = i2;
    }

    public void setColorValue(int i, String str, int i2) {
        ConstraintSet$Constraint.access$600(get(i), str, i2);
    }

    public void setDimensionRatio(int i, String str) {
        get(i).layout.dimensionRatio = str;
    }

    public void setEditorAbsoluteX(int i, int i2) {
        get(i).layout.editorAbsoluteX = i2;
    }

    public void setEditorAbsoluteY(int i, int i2) {
        get(i).layout.editorAbsoluteY = i2;
    }

    public void setElevation(int i, float f) {
        get(i).transform.elevation = f;
        get(i).transform.applyElevation = true;
    }

    public void setFloatValue(int i, String str, float f) {
        ConstraintSet$Constraint.access$700(get(i), str, f);
    }

    public void setForceId(boolean z2) {
        this.mForceId = z2;
    }

    public void setGoneMargin(int i, int i2, int i3) {
        ConstraintSet$Constraint constraintSet$Constraint = get(i);
        switch (i2) {
            case 1:
                constraintSet$Constraint.layout.goneLeftMargin = i3;
                return;
            case 2:
                constraintSet$Constraint.layout.goneRightMargin = i3;
                return;
            case 3:
                constraintSet$Constraint.layout.goneTopMargin = i3;
                return;
            case 4:
                constraintSet$Constraint.layout.goneBottomMargin = i3;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                constraintSet$Constraint.layout.goneStartMargin = i3;
                return;
            case 7:
                constraintSet$Constraint.layout.goneEndMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setGuidelineBegin(int i, int i2) {
        get(i).layout.guideBegin = i2;
        get(i).layout.guideEnd = -1;
        get(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelineEnd(int i, int i2) {
        get(i).layout.guideEnd = i2;
        get(i).layout.guideBegin = -1;
        get(i).layout.guidePercent = -1.0f;
    }

    public void setGuidelinePercent(int i, float f) {
        get(i).layout.guidePercent = f;
        get(i).layout.guideEnd = -1;
        get(i).layout.guideBegin = -1;
    }

    public void setHorizontalBias(int i, float f) {
        get(i).layout.horizontalBias = f;
    }

    public void setHorizontalChainStyle(int i, int i2) {
        get(i).layout.horizontalChainStyle = i2;
    }

    public void setHorizontalWeight(int i, float f) {
        get(i).layout.horizontalWeight = f;
    }

    public void setIntValue(int i, String str, int i2) {
        ConstraintSet$Constraint.access$500(get(i), str, i2);
    }

    public void setMargin(int i, int i2, int i3) {
        ConstraintSet$Constraint constraintSet$Constraint = get(i);
        switch (i2) {
            case 1:
                constraintSet$Constraint.layout.leftMargin = i3;
                return;
            case 2:
                constraintSet$Constraint.layout.rightMargin = i3;
                return;
            case 3:
                constraintSet$Constraint.layout.topMargin = i3;
                return;
            case 4:
                constraintSet$Constraint.layout.bottomMargin = i3;
                return;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                constraintSet$Constraint.layout.startMargin = i3;
                return;
            case 7:
                constraintSet$Constraint.layout.endMargin = i3;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void setReferencedIds(int i, int... iArr) {
        get(i).layout.mReferenceIds = iArr;
    }

    public void setRotation(int i, float f) {
        get(i).transform.rotation = f;
    }

    public void setRotationX(int i, float f) {
        get(i).transform.rotationX = f;
    }

    public void setRotationY(int i, float f) {
        get(i).transform.rotationY = f;
    }

    public void setScaleX(int i, float f) {
        get(i).transform.scaleX = f;
    }

    public void setScaleY(int i, float f) {
        get(i).transform.scaleY = f;
    }

    public void setStringValue(int i, String str, String str2) {
        ConstraintSet$Constraint.access$800(get(i), str, str2);
    }

    public void setTransformPivot(int i, float f, float f2) {
        ConstraintSet$Transform constraintSet$Transform = get(i).transform;
        constraintSet$Transform.transformPivotY = f2;
        constraintSet$Transform.transformPivotX = f;
    }

    public void setTransformPivotX(int i, float f) {
        get(i).transform.transformPivotX = f;
    }

    public void setTransformPivotY(int i, float f) {
        get(i).transform.transformPivotY = f;
    }

    public void setTranslation(int i, float f, float f2) {
        ConstraintSet$Transform constraintSet$Transform = get(i).transform;
        constraintSet$Transform.translationX = f;
        constraintSet$Transform.translationY = f2;
    }

    public void setTranslationX(int i, float f) {
        get(i).transform.translationX = f;
    }

    public void setTranslationY(int i, float f) {
        get(i).transform.translationY = f;
    }

    public void setTranslationZ(int i, float f) {
        get(i).transform.translationZ = f;
    }

    public void setValidateOnParse(boolean z2) {
        this.mValidate = z2;
    }

    public void setVerticalBias(int i, float f) {
        get(i).layout.verticalBias = f;
    }

    public void setVerticalChainStyle(int i, int i2) {
        get(i).layout.verticalChainStyle = i2;
    }

    public void setVerticalWeight(int i, float f) {
        get(i).layout.verticalWeight = f;
    }

    public void setVisibility(int i, int i2) {
        get(i).propertySet.visibility = i2;
    }

    public void setVisibilityMode(int i, int i2) {
        get(i).propertySet.mVisibilityMode = i2;
    }

    private void createHorizontalChain(int i, int i2, int i3, int i4, int[] iArr, float[] fArr, int i5, int i6, int i7) {
        if (iArr.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null && fArr.length != iArr.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (fArr != null) {
            get(iArr[0]).layout.horizontalWeight = fArr[0];
        }
        get(iArr[0]).layout.horizontalChainStyle = i5;
        connect(iArr[0], i6, i, i2, -1);
        for (int i8 = 1; i8 < iArr.length; i8++) {
            int i9 = iArr[i8];
            int i10 = i8 - 1;
            connect(iArr[i8], i6, iArr[i10], i7, -1);
            connect(iArr[i10], i7, iArr[i8], i6, -1);
            if (fArr != null) {
                get(iArr[i8]).layout.horizontalWeight = fArr[i8];
            }
        }
        connect(iArr[iArr.length - 1], i7, i3, i4, -1);
    }

    public void clear(int i, int i2) {
        if (this.mConstraints.containsKey(Integer.valueOf(i))) {
            ConstraintSet$Constraint constraintSet$Constraint = this.mConstraints.get(Integer.valueOf(i));
            switch (i2) {
                case 1:
                    ConstraintSet$Layout constraintSet$Layout = constraintSet$Constraint.layout;
                    constraintSet$Layout.leftToRight = -1;
                    constraintSet$Layout.leftToLeft = -1;
                    constraintSet$Layout.leftMargin = -1;
                    constraintSet$Layout.goneLeftMargin = -1;
                    return;
                case 2:
                    ConstraintSet$Layout constraintSet$Layout2 = constraintSet$Constraint.layout;
                    constraintSet$Layout2.rightToRight = -1;
                    constraintSet$Layout2.rightToLeft = -1;
                    constraintSet$Layout2.rightMargin = -1;
                    constraintSet$Layout2.goneRightMargin = -1;
                    return;
                case 3:
                    ConstraintSet$Layout constraintSet$Layout3 = constraintSet$Constraint.layout;
                    constraintSet$Layout3.topToBottom = -1;
                    constraintSet$Layout3.topToTop = -1;
                    constraintSet$Layout3.topMargin = -1;
                    constraintSet$Layout3.goneTopMargin = -1;
                    return;
                case 4:
                    ConstraintSet$Layout constraintSet$Layout4 = constraintSet$Constraint.layout;
                    constraintSet$Layout4.bottomToTop = -1;
                    constraintSet$Layout4.bottomToBottom = -1;
                    constraintSet$Layout4.bottomMargin = -1;
                    constraintSet$Layout4.goneBottomMargin = -1;
                    return;
                case 5:
                    constraintSet$Constraint.layout.baselineToBaseline = -1;
                    return;
                case 6:
                    ConstraintSet$Layout constraintSet$Layout5 = constraintSet$Constraint.layout;
                    constraintSet$Layout5.startToEnd = -1;
                    constraintSet$Layout5.startToStart = -1;
                    constraintSet$Layout5.startMargin = -1;
                    constraintSet$Layout5.goneStartMargin = -1;
                    return;
                case 7:
                    ConstraintSet$Layout constraintSet$Layout6 = constraintSet$Constraint.layout;
                    constraintSet$Layout6.endToStart = -1;
                    constraintSet$Layout6.endToEnd = -1;
                    constraintSet$Layout6.endMargin = -1;
                    constraintSet$Layout6.goneEndMargin = -1;
                    return;
                default:
                    throw new IllegalArgumentException("unknown constraint");
            }
        }
    }

    public void clone(ConstraintSet constraintSet) {
        this.mConstraints.clear();
        for (Integer num : constraintSet.mConstraints.keySet()) {
            this.mConstraints.put(num, constraintSet.mConstraints.get(num).clone());
        }
    }

    public void centerHorizontally(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            center(i, i2, 2, 0, i2, 1, 0, 0.5f);
        }
    }

    public void centerHorizontallyRtl(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            center(i, i2, 7, 0, i2, 6, 0, 0.5f);
        }
    }

    public void centerVertically(int i, int i2) {
        if (i2 == 0) {
            center(i, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            center(i, i2, 4, 0, i2, 3, 0, 0.5f);
        }
    }

    public void clone(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.mConstraints.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.mForceId && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                this.mConstraints.put(Integer.valueOf(id2), new ConstraintSet$Constraint());
            }
            ConstraintSet$Constraint constraintSet$Constraint = this.mConstraints.get(Integer.valueOf(id2));
            constraintSet$Constraint.mCustomConstraints = ConstraintAttribute.extractAttributes(this.mSavedAttributes, childAt);
            ConstraintSet$Constraint.access$000(constraintSet$Constraint, id2, constraintLayout$LayoutParams);
            constraintSet$Constraint.propertySet.visibility = childAt.getVisibility();
            constraintSet$Constraint.propertySet.alpha = childAt.getAlpha();
            constraintSet$Constraint.transform.rotation = childAt.getRotation();
            constraintSet$Constraint.transform.rotationX = childAt.getRotationX();
            constraintSet$Constraint.transform.rotationY = childAt.getRotationY();
            constraintSet$Constraint.transform.scaleX = childAt.getScaleX();
            constraintSet$Constraint.transform.scaleY = childAt.getScaleY();
            float pivotX = childAt.getPivotX();
            float pivotY = childAt.getPivotY();
            if (pivotX != 0.0d || pivotY != 0.0d) {
                ConstraintSet$Transform constraintSet$Transform = constraintSet$Constraint.transform;
                constraintSet$Transform.transformPivotX = pivotX;
                constraintSet$Transform.transformPivotY = pivotY;
            }
            constraintSet$Constraint.transform.translationX = childAt.getTranslationX();
            constraintSet$Constraint.transform.translationY = childAt.getTranslationY();
            constraintSet$Constraint.transform.translationZ = childAt.getTranslationZ();
            ConstraintSet$Transform constraintSet$Transform2 = constraintSet$Constraint.transform;
            if (constraintSet$Transform2.applyElevation) {
                constraintSet$Transform2.elevation = childAt.getElevation();
            }
            if (childAt instanceof Barrier) {
                Barrier barrier = (Barrier) childAt;
                constraintSet$Constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                constraintSet$Constraint.layout.mReferenceIds = barrier.getReferencedIds();
                constraintSet$Constraint.layout.mBarrierDirection = barrier.getType();
                constraintSet$Constraint.layout.mBarrierMargin = barrier.getMargin();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    public void load(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet$Constraint constraintSet$ConstraintFillFromAttributeList;
        try {
            int eventType = xmlPullParser.getEventType();
            ConstraintSet$Constraint constraintSet$Constraint = null;
            while (eventType != 1) {
                if (eventType != 0) {
                    if (eventType == 2) {
                        switch (xmlPullParser.getName()) {
                            case "Constraint":
                                constraintSet$ConstraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                break;
                            case "Guideline":
                                constraintSet$ConstraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                ConstraintSet$Layout constraintSet$Layout = constraintSet$ConstraintFillFromAttributeList.layout;
                                constraintSet$Layout.mIsGuideline = true;
                                constraintSet$Layout.mApply = true;
                                break;
                            case "Barrier":
                                constraintSet$ConstraintFillFromAttributeList = fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                constraintSet$ConstraintFillFromAttributeList.layout.mHelperType = 1;
                                break;
                            case "PropertySet":
                                if (constraintSet$Constraint != null) {
                                    constraintSet$Constraint.propertySet.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    continue;
                                    break;
                                } else {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                break;
                            case "Transform":
                                if (constraintSet$Constraint != null) {
                                    constraintSet$Constraint.transform.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    continue;
                                    break;
                                } else {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                break;
                            case "Layout":
                                if (constraintSet$Constraint != null) {
                                    constraintSet$Constraint.layout.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    continue;
                                    break;
                                } else {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                break;
                            case "Motion":
                                if (constraintSet$Constraint != null) {
                                    constraintSet$Constraint.motion.fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
                                    continue;
                                    break;
                                } else {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                break;
                            case "CustomAttribute":
                                if (constraintSet$Constraint != null) {
                                    ConstraintAttribute.parse(context, xmlPullParser, constraintSet$Constraint.mCustomConstraints);
                                    continue;
                                    break;
                                } else {
                                    throw new RuntimeException(ERROR_MESSAGE + xmlPullParser.getLineNumber());
                                }
                                break;
                            default:
                                continue;
                                break;
                        }
                        constraintSet$Constraint = constraintSet$ConstraintFillFromAttributeList;
                    } else if (eventType != 3) {
                        continue;
                    } else {
                        String name = xmlPullParser.getName();
                        if (TAG.equals(name)) {
                            return;
                        }
                        if (name.equalsIgnoreCase("Constraint")) {
                            this.mConstraints.put(Integer.valueOf(constraintSet$Constraint.mViewId), constraintSet$Constraint);
                            constraintSet$Constraint = null;
                        }
                    }
                } else {
                    xmlPullParser.getName();
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public void readFallback(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.mForceId && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                this.mConstraints.put(Integer.valueOf(id2), new ConstraintSet$Constraint());
            }
            ConstraintSet$Constraint constraintSet$Constraint = this.mConstraints.get(Integer.valueOf(id2));
            if (!constraintSet$Constraint.layout.mApply) {
                ConstraintSet$Constraint.access$000(constraintSet$Constraint, id2, constraintLayout$LayoutParams);
                if (childAt instanceof ConstraintHelper) {
                    constraintSet$Constraint.layout.mReferenceIds = ((ConstraintHelper) childAt).getReferencedIds();
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        constraintSet$Constraint.layout.mBarrierAllowsGoneWidgets = barrier.allowsGoneWidget();
                        constraintSet$Constraint.layout.mBarrierDirection = barrier.getType();
                        constraintSet$Constraint.layout.mBarrierMargin = barrier.getMargin();
                    }
                }
                constraintSet$Constraint.layout.mApply = true;
            }
            ConstraintSet$PropertySet constraintSet$PropertySet = constraintSet$Constraint.propertySet;
            if (!constraintSet$PropertySet.mApply) {
                constraintSet$PropertySet.visibility = childAt.getVisibility();
                constraintSet$Constraint.propertySet.alpha = childAt.getAlpha();
                constraintSet$Constraint.propertySet.mApply = true;
            }
            ConstraintSet$Transform constraintSet$Transform = constraintSet$Constraint.transform;
            if (!constraintSet$Transform.mApply) {
                constraintSet$Transform.mApply = true;
                constraintSet$Transform.rotation = childAt.getRotation();
                constraintSet$Constraint.transform.rotationX = childAt.getRotationX();
                constraintSet$Constraint.transform.rotationY = childAt.getRotationY();
                constraintSet$Constraint.transform.scaleX = childAt.getScaleX();
                constraintSet$Constraint.transform.scaleY = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    ConstraintSet$Transform constraintSet$Transform2 = constraintSet$Constraint.transform;
                    constraintSet$Transform2.transformPivotX = pivotX;
                    constraintSet$Transform2.transformPivotY = pivotY;
                }
                constraintSet$Constraint.transform.translationX = childAt.getTranslationX();
                constraintSet$Constraint.transform.translationY = childAt.getTranslationY();
                constraintSet$Constraint.transform.translationZ = childAt.getTranslationZ();
                ConstraintSet$Transform constraintSet$Transform3 = constraintSet$Constraint.transform;
                if (constraintSet$Transform3.applyElevation) {
                    constraintSet$Transform3.elevation = childAt.getElevation();
                }
            }
        }
    }

    public void clone(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.mConstraints.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraints.getChildAt(i);
            Constraints$LayoutParams constraints$LayoutParams = (Constraints$LayoutParams) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.mForceId && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.mConstraints.containsKey(Integer.valueOf(id2))) {
                this.mConstraints.put(Integer.valueOf(id2), new ConstraintSet$Constraint());
            }
            ConstraintSet$Constraint constraintSet$Constraint = this.mConstraints.get(Integer.valueOf(id2));
            if (childAt instanceof ConstraintHelper) {
                ConstraintSet$Constraint.access$300(constraintSet$Constraint, (ConstraintHelper) childAt, id2, constraints$LayoutParams);
            }
            ConstraintSet$Constraint.access$400(constraintSet$Constraint, id2, constraints$LayoutParams);
        }
    }

    public void connect(int i, int i2, int i3, int i4) {
        if (!this.mConstraints.containsKey(Integer.valueOf(i))) {
            this.mConstraints.put(Integer.valueOf(i), new ConstraintSet$Constraint());
        }
        ConstraintSet$Constraint constraintSet$Constraint = this.mConstraints.get(Integer.valueOf(i));
        switch (i2) {
            case 1:
                if (i4 == 1) {
                    ConstraintSet$Layout constraintSet$Layout = constraintSet$Constraint.layout;
                    constraintSet$Layout.leftToLeft = i3;
                    constraintSet$Layout.leftToRight = -1;
                    return;
                } else {
                    if (i4 == 2) {
                        ConstraintSet$Layout constraintSet$Layout2 = constraintSet$Constraint.layout;
                        constraintSet$Layout2.leftToRight = i3;
                        constraintSet$Layout2.leftToLeft = -1;
                        return;
                    }
                    throw new IllegalArgumentException(a.J(a.U("left to "), sideToString(i4), " undefined"));
                }
            case 2:
                if (i4 == 1) {
                    ConstraintSet$Layout constraintSet$Layout3 = constraintSet$Constraint.layout;
                    constraintSet$Layout3.rightToLeft = i3;
                    constraintSet$Layout3.rightToRight = -1;
                    return;
                } else {
                    if (i4 == 2) {
                        ConstraintSet$Layout constraintSet$Layout4 = constraintSet$Constraint.layout;
                        constraintSet$Layout4.rightToRight = i3;
                        constraintSet$Layout4.rightToLeft = -1;
                        return;
                    }
                    throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
                }
            case 3:
                if (i4 == 3) {
                    ConstraintSet$Layout constraintSet$Layout5 = constraintSet$Constraint.layout;
                    constraintSet$Layout5.topToTop = i3;
                    constraintSet$Layout5.topToBottom = -1;
                    constraintSet$Layout5.baselineToBaseline = -1;
                    return;
                }
                if (i4 == 4) {
                    ConstraintSet$Layout constraintSet$Layout6 = constraintSet$Constraint.layout;
                    constraintSet$Layout6.topToBottom = i3;
                    constraintSet$Layout6.topToTop = -1;
                    constraintSet$Layout6.baselineToBaseline = -1;
                    return;
                }
                throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
            case 4:
                if (i4 == 4) {
                    ConstraintSet$Layout constraintSet$Layout7 = constraintSet$Constraint.layout;
                    constraintSet$Layout7.bottomToBottom = i3;
                    constraintSet$Layout7.bottomToTop = -1;
                    constraintSet$Layout7.baselineToBaseline = -1;
                    return;
                }
                if (i4 == 3) {
                    ConstraintSet$Layout constraintSet$Layout8 = constraintSet$Constraint.layout;
                    constraintSet$Layout8.bottomToTop = i3;
                    constraintSet$Layout8.bottomToBottom = -1;
                    constraintSet$Layout8.baselineToBaseline = -1;
                    return;
                }
                throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
            case 5:
                if (i4 == 5) {
                    ConstraintSet$Layout constraintSet$Layout9 = constraintSet$Constraint.layout;
                    constraintSet$Layout9.baselineToBaseline = i3;
                    constraintSet$Layout9.bottomToBottom = -1;
                    constraintSet$Layout9.bottomToTop = -1;
                    constraintSet$Layout9.topToTop = -1;
                    constraintSet$Layout9.topToBottom = -1;
                    return;
                }
                throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
            case 6:
                if (i4 == 6) {
                    ConstraintSet$Layout constraintSet$Layout10 = constraintSet$Constraint.layout;
                    constraintSet$Layout10.startToStart = i3;
                    constraintSet$Layout10.startToEnd = -1;
                    return;
                } else {
                    if (i4 == 7) {
                        ConstraintSet$Layout constraintSet$Layout11 = constraintSet$Constraint.layout;
                        constraintSet$Layout11.startToEnd = i3;
                        constraintSet$Layout11.startToStart = -1;
                        return;
                    }
                    throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
                }
            case 7:
                if (i4 == 7) {
                    ConstraintSet$Layout constraintSet$Layout12 = constraintSet$Constraint.layout;
                    constraintSet$Layout12.endToEnd = i3;
                    constraintSet$Layout12.endToStart = -1;
                    return;
                } else {
                    if (i4 == 6) {
                        ConstraintSet$Layout constraintSet$Layout13 = constraintSet$Constraint.layout;
                        constraintSet$Layout13.endToStart = i3;
                        constraintSet$Layout13.endToEnd = -1;
                        return;
                    }
                    throw new IllegalArgumentException(a.J(a.U("right to "), sideToString(i4), " undefined"));
                }
            default:
                StringBuilder sb = new StringBuilder();
                sb.append(sideToString(i2));
                sb.append(" to ");
                throw new IllegalArgumentException(a.J(sb, sideToString(i4), " unknown"));
        }
    }
}
