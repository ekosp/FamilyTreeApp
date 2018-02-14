package co.familytreeapp.model

import android.database.Cursor
import co.familytreeapp.database.schemas.ChildrenSchema

/**
 * Represents a single relationship between a parent and its child.
 *
 * @property parentId   the person ID of the parent
 * @property childId    the person ID of the child
 *
 * @see Person.id
 */
data class ChildRelationship(val parentId: Int, val childId: Int): DataRelationship {

    companion object {

        /**
         * Instantiates a [ChildRelationship] object by getting values in columns from a [cursor].
         */
        @JvmStatic fun from(cursor: Cursor) = ChildRelationship(
                cursor.getInt(cursor.getColumnIndex(ChildrenSchema.COL_PARENT_ID)),
                cursor.getInt(cursor.getColumnIndex(ChildrenSchema.COL_CHILD_ID))
        )
    }

    override fun getIds() = Pair(parentId, childId)

}
