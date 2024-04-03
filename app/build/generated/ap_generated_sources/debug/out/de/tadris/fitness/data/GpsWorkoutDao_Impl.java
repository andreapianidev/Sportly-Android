package de.tadris.fitness.data;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GpsWorkoutDao_Impl implements GpsWorkoutDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<GpsWorkout> __insertionAdapterOfGpsWorkout;

  private final EntityInsertionAdapter<GpsSample> __insertionAdapterOfGpsSample;

  private final EntityDeletionOrUpdateAdapter<GpsWorkout> __deletionAdapterOfGpsWorkout;

  private final EntityDeletionOrUpdateAdapter<GpsSample> __deletionAdapterOfGpsSample;

  private final EntityDeletionOrUpdateAdapter<GpsWorkout> __updateAdapterOfGpsWorkout;

  private final EntityDeletionOrUpdateAdapter<GpsSample> __updateAdapterOfGpsSample;

  public GpsWorkoutDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGpsWorkout = new EntityInsertionAdapter<GpsWorkout>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workout` (`length`,`avgSpeed`,`topSpeed`,`avgPace`,`min_elevation_msl`,`max_elevation_msl`,`ascent`,`descent`,`id`,`start`,`end`,`duration`,`pauseDuration`,`comment`,`workoutType`,`avg_heart_rate`,`max_heart_rate`,`calorie`,`edited`,`interval_set_used_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GpsWorkout value) {
        stmt.bindLong(1, value.length);
        stmt.bindDouble(2, value.avgSpeed);
        stmt.bindDouble(3, value.topSpeed);
        stmt.bindDouble(4, value.avgPace);
        stmt.bindDouble(5, value.minElevationMSL);
        stmt.bindDouble(6, value.maxElevationMSL);
        stmt.bindDouble(7, value.ascent);
        stmt.bindDouble(8, value.descent);
        stmt.bindLong(9, value.id);
        stmt.bindLong(10, value.start);
        stmt.bindLong(11, value.end);
        stmt.bindLong(12, value.duration);
        stmt.bindLong(13, value.pauseDuration);
        if (value.comment == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.comment);
        }
        if (value.workoutTypeId == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.workoutTypeId);
        }
        stmt.bindLong(16, value.avgHeartRate);
        stmt.bindLong(17, value.maxHeartRate);
        stmt.bindLong(18, value.calorie);
        final int _tmp = value.edited ? 1 : 0;
        stmt.bindLong(19, _tmp);
        stmt.bindLong(20, value.intervalSetUsedId);
      }
    };
    this.__insertionAdapterOfGpsSample = new EntityInsertionAdapter<GpsSample>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `workout_sample` (`workout_id`,`lat`,`lon`,`elevation`,`elevation_msl`,`speed`,`pressure`,`id`,`absoluteTime`,`relativeTime`,`heart_rate`,`interval_triggered`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GpsSample value) {
        stmt.bindLong(1, value.workoutId);
        stmt.bindDouble(2, value.lat);
        stmt.bindDouble(3, value.lon);
        stmt.bindDouble(4, value.elevation);
        stmt.bindDouble(5, value.elevationMSL);
        stmt.bindDouble(6, value.speed);
        stmt.bindDouble(7, value.pressure);
        stmt.bindLong(8, value.id);
        stmt.bindLong(9, value.absoluteTime);
        stmt.bindLong(10, value.relativeTime);
        stmt.bindLong(11, value.heartRate);
        stmt.bindLong(12, value.intervalTriggered);
      }
    };
    this.__deletionAdapterOfGpsWorkout = new EntityDeletionOrUpdateAdapter<GpsWorkout>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `workout` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GpsWorkout value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__deletionAdapterOfGpsSample = new EntityDeletionOrUpdateAdapter<GpsSample>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `workout_sample` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GpsSample value) {
        stmt.bindLong(1, value.id);
      }
    };
    this.__updateAdapterOfGpsWorkout = new EntityDeletionOrUpdateAdapter<GpsWorkout>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `workout` SET `length` = ?,`avgSpeed` = ?,`topSpeed` = ?,`avgPace` = ?,`min_elevation_msl` = ?,`max_elevation_msl` = ?,`ascent` = ?,`descent` = ?,`id` = ?,`start` = ?,`end` = ?,`duration` = ?,`pauseDuration` = ?,`comment` = ?,`workoutType` = ?,`avg_heart_rate` = ?,`max_heart_rate` = ?,`calorie` = ?,`edited` = ?,`interval_set_used_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GpsWorkout value) {
        stmt.bindLong(1, value.length);
        stmt.bindDouble(2, value.avgSpeed);
        stmt.bindDouble(3, value.topSpeed);
        stmt.bindDouble(4, value.avgPace);
        stmt.bindDouble(5, value.minElevationMSL);
        stmt.bindDouble(6, value.maxElevationMSL);
        stmt.bindDouble(7, value.ascent);
        stmt.bindDouble(8, value.descent);
        stmt.bindLong(9, value.id);
        stmt.bindLong(10, value.start);
        stmt.bindLong(11, value.end);
        stmt.bindLong(12, value.duration);
        stmt.bindLong(13, value.pauseDuration);
        if (value.comment == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.comment);
        }
        if (value.workoutTypeId == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.workoutTypeId);
        }
        stmt.bindLong(16, value.avgHeartRate);
        stmt.bindLong(17, value.maxHeartRate);
        stmt.bindLong(18, value.calorie);
        final int _tmp = value.edited ? 1 : 0;
        stmt.bindLong(19, _tmp);
        stmt.bindLong(20, value.intervalSetUsedId);
        stmt.bindLong(21, value.id);
      }
    };
    this.__updateAdapterOfGpsSample = new EntityDeletionOrUpdateAdapter<GpsSample>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `workout_sample` SET `workout_id` = ?,`lat` = ?,`lon` = ?,`elevation` = ?,`elevation_msl` = ?,`speed` = ?,`pressure` = ?,`id` = ?,`absoluteTime` = ?,`relativeTime` = ?,`heart_rate` = ?,`interval_triggered` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, GpsSample value) {
        stmt.bindLong(1, value.workoutId);
        stmt.bindDouble(2, value.lat);
        stmt.bindDouble(3, value.lon);
        stmt.bindDouble(4, value.elevation);
        stmt.bindDouble(5, value.elevationMSL);
        stmt.bindDouble(6, value.speed);
        stmt.bindDouble(7, value.pressure);
        stmt.bindLong(8, value.id);
        stmt.bindLong(9, value.absoluteTime);
        stmt.bindLong(10, value.relativeTime);
        stmt.bindLong(11, value.heartRate);
        stmt.bindLong(12, value.intervalTriggered);
        stmt.bindLong(13, value.id);
      }
    };
  }

  @Override
  public void insertWorkoutAndSamples(final GpsWorkout workout, final GpsSample[] samples) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGpsWorkout.insert(workout);
      __insertionAdapterOfGpsSample.insert(samples);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertWorkout(final GpsWorkout workout) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGpsWorkout.insert(workout);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertSample(final GpsSample sample) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfGpsSample.insert(sample);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteWorkoutAndSamples(final GpsWorkout workout, final GpsSample[] toArray) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfGpsWorkout.handle(workout);
      __deletionAdapterOfGpsSample.handleMultiple(toArray);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteWorkout(final GpsWorkout workout) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfGpsWorkout.handle(workout);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteSample(final GpsSample sample) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfGpsSample.handle(sample);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateWorkout(final GpsWorkout workout) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfGpsWorkout.handle(workout);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSamples(final GpsSample[] samples) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfGpsSample.handleMultiple(samples);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSample(final GpsSample sample) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfGpsSample.handle(sample);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public GpsWorkout findById(final long id) {
    final String _sql = "SELECT * FROM workout WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLength = CursorUtil.getColumnIndexOrThrow(_cursor, "length");
      final int _cursorIndexOfAvgSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "avgSpeed");
      final int _cursorIndexOfTopSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "topSpeed");
      final int _cursorIndexOfAvgPace = CursorUtil.getColumnIndexOrThrow(_cursor, "avgPace");
      final int _cursorIndexOfMinElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "min_elevation_msl");
      final int _cursorIndexOfMaxElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "max_elevation_msl");
      final int _cursorIndexOfAscent = CursorUtil.getColumnIndexOrThrow(_cursor, "ascent");
      final int _cursorIndexOfDescent = CursorUtil.getColumnIndexOrThrow(_cursor, "descent");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final GpsWorkout _result;
      if(_cursor.moveToFirst()) {
        _result = new GpsWorkout();
        _result.length = _cursor.getInt(_cursorIndexOfLength);
        _result.avgSpeed = _cursor.getDouble(_cursorIndexOfAvgSpeed);
        _result.topSpeed = _cursor.getDouble(_cursorIndexOfTopSpeed);
        _result.avgPace = _cursor.getDouble(_cursorIndexOfAvgPace);
        _result.minElevationMSL = _cursor.getFloat(_cursorIndexOfMinElevationMSL);
        _result.maxElevationMSL = _cursor.getFloat(_cursorIndexOfMaxElevationMSL);
        _result.ascent = _cursor.getFloat(_cursorIndexOfAscent);
        _result.descent = _cursor.getFloat(_cursorIndexOfDescent);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.start = _cursor.getLong(_cursorIndexOfStart);
        _result.end = _cursor.getLong(_cursorIndexOfEnd);
        _result.duration = _cursor.getLong(_cursorIndexOfDuration);
        _result.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _result.comment = null;
        } else {
          _result.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _result.workoutTypeId = null;
        } else {
          _result.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _result.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _result.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _result.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _result.edited = _tmp != 0;
        _result.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GpsSample findSampleById(final long id) {
    final String _sql = "SELECT * FROM workout_sample WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfWorkoutId = CursorUtil.getColumnIndexOrThrow(_cursor, "workout_id");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLon = CursorUtil.getColumnIndexOrThrow(_cursor, "lon");
      final int _cursorIndexOfElevation = CursorUtil.getColumnIndexOrThrow(_cursor, "elevation");
      final int _cursorIndexOfElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "elevation_msl");
      final int _cursorIndexOfSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "speed");
      final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAbsoluteTime = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteTime");
      final int _cursorIndexOfRelativeTime = CursorUtil.getColumnIndexOrThrow(_cursor, "relativeTime");
      final int _cursorIndexOfHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "heart_rate");
      final int _cursorIndexOfIntervalTriggered = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_triggered");
      final GpsSample _result;
      if(_cursor.moveToFirst()) {
        _result = new GpsSample();
        _result.workoutId = _cursor.getLong(_cursorIndexOfWorkoutId);
        _result.lat = _cursor.getDouble(_cursorIndexOfLat);
        _result.lon = _cursor.getDouble(_cursorIndexOfLon);
        _result.elevation = _cursor.getDouble(_cursorIndexOfElevation);
        _result.elevationMSL = _cursor.getDouble(_cursorIndexOfElevationMSL);
        _result.speed = _cursor.getDouble(_cursorIndexOfSpeed);
        _result.pressure = _cursor.getFloat(_cursorIndexOfPressure);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.absoluteTime = _cursor.getLong(_cursorIndexOfAbsoluteTime);
        _result.relativeTime = _cursor.getLong(_cursorIndexOfRelativeTime);
        _result.heartRate = _cursor.getInt(_cursorIndexOfHeartRate);
        _result.intervalTriggered = _cursor.getLong(_cursorIndexOfIntervalTriggered);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GpsSample[] getAllSamplesOfWorkout(final long workout_id) {
    final String _sql = "SELECT * FROM workout_sample WHERE workout_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, workout_id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfWorkoutId = CursorUtil.getColumnIndexOrThrow(_cursor, "workout_id");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLon = CursorUtil.getColumnIndexOrThrow(_cursor, "lon");
      final int _cursorIndexOfElevation = CursorUtil.getColumnIndexOrThrow(_cursor, "elevation");
      final int _cursorIndexOfElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "elevation_msl");
      final int _cursorIndexOfSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "speed");
      final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAbsoluteTime = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteTime");
      final int _cursorIndexOfRelativeTime = CursorUtil.getColumnIndexOrThrow(_cursor, "relativeTime");
      final int _cursorIndexOfHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "heart_rate");
      final int _cursorIndexOfIntervalTriggered = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_triggered");
      final GpsSample[] _result = new GpsSample[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final GpsSample _item;
        _item = new GpsSample();
        _item.workoutId = _cursor.getLong(_cursorIndexOfWorkoutId);
        _item.lat = _cursor.getDouble(_cursorIndexOfLat);
        _item.lon = _cursor.getDouble(_cursorIndexOfLon);
        _item.elevation = _cursor.getDouble(_cursorIndexOfElevation);
        _item.elevationMSL = _cursor.getDouble(_cursorIndexOfElevationMSL);
        _item.speed = _cursor.getDouble(_cursorIndexOfSpeed);
        _item.pressure = _cursor.getFloat(_cursorIndexOfPressure);
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.absoluteTime = _cursor.getLong(_cursorIndexOfAbsoluteTime);
        _item.relativeTime = _cursor.getLong(_cursorIndexOfRelativeTime);
        _item.heartRate = _cursor.getInt(_cursorIndexOfHeartRate);
        _item.intervalTriggered = _cursor.getLong(_cursorIndexOfIntervalTriggered);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GpsWorkout[] getWorkouts() {
    final String _sql = "SELECT * FROM workout ORDER BY start DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLength = CursorUtil.getColumnIndexOrThrow(_cursor, "length");
      final int _cursorIndexOfAvgSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "avgSpeed");
      final int _cursorIndexOfTopSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "topSpeed");
      final int _cursorIndexOfAvgPace = CursorUtil.getColumnIndexOrThrow(_cursor, "avgPace");
      final int _cursorIndexOfMinElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "min_elevation_msl");
      final int _cursorIndexOfMaxElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "max_elevation_msl");
      final int _cursorIndexOfAscent = CursorUtil.getColumnIndexOrThrow(_cursor, "ascent");
      final int _cursorIndexOfDescent = CursorUtil.getColumnIndexOrThrow(_cursor, "descent");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final GpsWorkout[] _result = new GpsWorkout[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final GpsWorkout _item;
        _item = new GpsWorkout();
        _item.length = _cursor.getInt(_cursorIndexOfLength);
        _item.avgSpeed = _cursor.getDouble(_cursorIndexOfAvgSpeed);
        _item.topSpeed = _cursor.getDouble(_cursorIndexOfTopSpeed);
        _item.avgPace = _cursor.getDouble(_cursorIndexOfAvgPace);
        _item.minElevationMSL = _cursor.getFloat(_cursorIndexOfMinElevationMSL);
        _item.maxElevationMSL = _cursor.getFloat(_cursorIndexOfMaxElevationMSL);
        _item.ascent = _cursor.getFloat(_cursorIndexOfAscent);
        _item.descent = _cursor.getFloat(_cursorIndexOfDescent);
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.start = _cursor.getLong(_cursorIndexOfStart);
        _item.end = _cursor.getLong(_cursorIndexOfEnd);
        _item.duration = _cursor.getLong(_cursorIndexOfDuration);
        _item.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _item.comment = null;
        } else {
          _item.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _item.workoutTypeId = null;
        } else {
          _item.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _item.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _item.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _item.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _item.edited = _tmp != 0;
        _item.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GpsWorkout getLastWorkout() {
    final String _sql = "SELECT * FROM workout ORDER BY start DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLength = CursorUtil.getColumnIndexOrThrow(_cursor, "length");
      final int _cursorIndexOfAvgSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "avgSpeed");
      final int _cursorIndexOfTopSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "topSpeed");
      final int _cursorIndexOfAvgPace = CursorUtil.getColumnIndexOrThrow(_cursor, "avgPace");
      final int _cursorIndexOfMinElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "min_elevation_msl");
      final int _cursorIndexOfMaxElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "max_elevation_msl");
      final int _cursorIndexOfAscent = CursorUtil.getColumnIndexOrThrow(_cursor, "ascent");
      final int _cursorIndexOfDescent = CursorUtil.getColumnIndexOrThrow(_cursor, "descent");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final GpsWorkout _result;
      if(_cursor.moveToFirst()) {
        _result = new GpsWorkout();
        _result.length = _cursor.getInt(_cursorIndexOfLength);
        _result.avgSpeed = _cursor.getDouble(_cursorIndexOfAvgSpeed);
        _result.topSpeed = _cursor.getDouble(_cursorIndexOfTopSpeed);
        _result.avgPace = _cursor.getDouble(_cursorIndexOfAvgPace);
        _result.minElevationMSL = _cursor.getFloat(_cursorIndexOfMinElevationMSL);
        _result.maxElevationMSL = _cursor.getFloat(_cursorIndexOfMaxElevationMSL);
        _result.ascent = _cursor.getFloat(_cursorIndexOfAscent);
        _result.descent = _cursor.getFloat(_cursorIndexOfDescent);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.start = _cursor.getLong(_cursorIndexOfStart);
        _result.end = _cursor.getLong(_cursorIndexOfEnd);
        _result.duration = _cursor.getLong(_cursorIndexOfDuration);
        _result.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _result.comment = null;
        } else {
          _result.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _result.workoutTypeId = null;
        } else {
          _result.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _result.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _result.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _result.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _result.edited = _tmp != 0;
        _result.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GpsWorkout getLastWorkoutByType(final String type) {
    final String _sql = "SELECT * FROM workout WHERE workoutType = ? ORDER BY start DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLength = CursorUtil.getColumnIndexOrThrow(_cursor, "length");
      final int _cursorIndexOfAvgSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "avgSpeed");
      final int _cursorIndexOfTopSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "topSpeed");
      final int _cursorIndexOfAvgPace = CursorUtil.getColumnIndexOrThrow(_cursor, "avgPace");
      final int _cursorIndexOfMinElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "min_elevation_msl");
      final int _cursorIndexOfMaxElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "max_elevation_msl");
      final int _cursorIndexOfAscent = CursorUtil.getColumnIndexOrThrow(_cursor, "ascent");
      final int _cursorIndexOfDescent = CursorUtil.getColumnIndexOrThrow(_cursor, "descent");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final GpsWorkout _result;
      if(_cursor.moveToFirst()) {
        _result = new GpsWorkout();
        _result.length = _cursor.getInt(_cursorIndexOfLength);
        _result.avgSpeed = _cursor.getDouble(_cursorIndexOfAvgSpeed);
        _result.topSpeed = _cursor.getDouble(_cursorIndexOfTopSpeed);
        _result.avgPace = _cursor.getDouble(_cursorIndexOfAvgPace);
        _result.minElevationMSL = _cursor.getFloat(_cursorIndexOfMinElevationMSL);
        _result.maxElevationMSL = _cursor.getFloat(_cursorIndexOfMaxElevationMSL);
        _result.ascent = _cursor.getFloat(_cursorIndexOfAscent);
        _result.descent = _cursor.getFloat(_cursorIndexOfDescent);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.start = _cursor.getLong(_cursorIndexOfStart);
        _result.end = _cursor.getLong(_cursorIndexOfEnd);
        _result.duration = _cursor.getLong(_cursorIndexOfDuration);
        _result.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _result.comment = null;
        } else {
          _result.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _result.workoutTypeId = null;
        } else {
          _result.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _result.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _result.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _result.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _result.edited = _tmp != 0;
        _result.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GpsWorkout[] getAllWorkoutsHistorically() {
    final String _sql = "SELECT * FROM workout ORDER BY start ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLength = CursorUtil.getColumnIndexOrThrow(_cursor, "length");
      final int _cursorIndexOfAvgSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "avgSpeed");
      final int _cursorIndexOfTopSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "topSpeed");
      final int _cursorIndexOfAvgPace = CursorUtil.getColumnIndexOrThrow(_cursor, "avgPace");
      final int _cursorIndexOfMinElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "min_elevation_msl");
      final int _cursorIndexOfMaxElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "max_elevation_msl");
      final int _cursorIndexOfAscent = CursorUtil.getColumnIndexOrThrow(_cursor, "ascent");
      final int _cursorIndexOfDescent = CursorUtil.getColumnIndexOrThrow(_cursor, "descent");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final GpsWorkout[] _result = new GpsWorkout[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final GpsWorkout _item;
        _item = new GpsWorkout();
        _item.length = _cursor.getInt(_cursorIndexOfLength);
        _item.avgSpeed = _cursor.getDouble(_cursorIndexOfAvgSpeed);
        _item.topSpeed = _cursor.getDouble(_cursorIndexOfTopSpeed);
        _item.avgPace = _cursor.getDouble(_cursorIndexOfAvgPace);
        _item.minElevationMSL = _cursor.getFloat(_cursorIndexOfMinElevationMSL);
        _item.maxElevationMSL = _cursor.getFloat(_cursorIndexOfMaxElevationMSL);
        _item.ascent = _cursor.getFloat(_cursorIndexOfAscent);
        _item.descent = _cursor.getFloat(_cursorIndexOfDescent);
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.start = _cursor.getLong(_cursorIndexOfStart);
        _item.end = _cursor.getLong(_cursorIndexOfEnd);
        _item.duration = _cursor.getLong(_cursorIndexOfDuration);
        _item.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _item.comment = null;
        } else {
          _item.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _item.workoutTypeId = null;
        } else {
          _item.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _item.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _item.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _item.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _item.edited = _tmp != 0;
        _item.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GpsWorkout[] getWorkoutsHistorically(final String workout_type) {
    final String _sql = "SELECT * FROM workout WHERE workoutType = ? ORDER BY start ASC ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (workout_type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, workout_type);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLength = CursorUtil.getColumnIndexOrThrow(_cursor, "length");
      final int _cursorIndexOfAvgSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "avgSpeed");
      final int _cursorIndexOfTopSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "topSpeed");
      final int _cursorIndexOfAvgPace = CursorUtil.getColumnIndexOrThrow(_cursor, "avgPace");
      final int _cursorIndexOfMinElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "min_elevation_msl");
      final int _cursorIndexOfMaxElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "max_elevation_msl");
      final int _cursorIndexOfAscent = CursorUtil.getColumnIndexOrThrow(_cursor, "ascent");
      final int _cursorIndexOfDescent = CursorUtil.getColumnIndexOrThrow(_cursor, "descent");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final GpsWorkout[] _result = new GpsWorkout[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final GpsWorkout _item;
        _item = new GpsWorkout();
        _item.length = _cursor.getInt(_cursorIndexOfLength);
        _item.avgSpeed = _cursor.getDouble(_cursorIndexOfAvgSpeed);
        _item.topSpeed = _cursor.getDouble(_cursorIndexOfTopSpeed);
        _item.avgPace = _cursor.getDouble(_cursorIndexOfAvgPace);
        _item.minElevationMSL = _cursor.getFloat(_cursorIndexOfMinElevationMSL);
        _item.maxElevationMSL = _cursor.getFloat(_cursorIndexOfMaxElevationMSL);
        _item.ascent = _cursor.getFloat(_cursorIndexOfAscent);
        _item.descent = _cursor.getFloat(_cursorIndexOfDescent);
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.start = _cursor.getLong(_cursorIndexOfStart);
        _item.end = _cursor.getLong(_cursorIndexOfEnd);
        _item.duration = _cursor.getLong(_cursorIndexOfDuration);
        _item.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _item.comment = null;
        } else {
          _item.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _item.workoutTypeId = null;
        } else {
          _item.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _item.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _item.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _item.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _item.edited = _tmp != 0;
        _item.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GpsWorkout getWorkoutByStart(final long start) {
    final String _sql = "SELECT * FROM workout WHERE start = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, start);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLength = CursorUtil.getColumnIndexOrThrow(_cursor, "length");
      final int _cursorIndexOfAvgSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "avgSpeed");
      final int _cursorIndexOfTopSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "topSpeed");
      final int _cursorIndexOfAvgPace = CursorUtil.getColumnIndexOrThrow(_cursor, "avgPace");
      final int _cursorIndexOfMinElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "min_elevation_msl");
      final int _cursorIndexOfMaxElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "max_elevation_msl");
      final int _cursorIndexOfAscent = CursorUtil.getColumnIndexOrThrow(_cursor, "ascent");
      final int _cursorIndexOfDescent = CursorUtil.getColumnIndexOrThrow(_cursor, "descent");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final GpsWorkout _result;
      if(_cursor.moveToFirst()) {
        _result = new GpsWorkout();
        _result.length = _cursor.getInt(_cursorIndexOfLength);
        _result.avgSpeed = _cursor.getDouble(_cursorIndexOfAvgSpeed);
        _result.topSpeed = _cursor.getDouble(_cursorIndexOfTopSpeed);
        _result.avgPace = _cursor.getDouble(_cursorIndexOfAvgPace);
        _result.minElevationMSL = _cursor.getFloat(_cursorIndexOfMinElevationMSL);
        _result.maxElevationMSL = _cursor.getFloat(_cursorIndexOfMaxElevationMSL);
        _result.ascent = _cursor.getFloat(_cursorIndexOfAscent);
        _result.descent = _cursor.getFloat(_cursorIndexOfDescent);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.start = _cursor.getLong(_cursorIndexOfStart);
        _result.end = _cursor.getLong(_cursorIndexOfEnd);
        _result.duration = _cursor.getLong(_cursorIndexOfDuration);
        _result.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _result.comment = null;
        } else {
          _result.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _result.workoutTypeId = null;
        } else {
          _result.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _result.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _result.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _result.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _result.edited = _tmp != 0;
        _result.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GpsWorkout getWorkoutById(final long id) {
    final String _sql = "SELECT * FROM workout WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLength = CursorUtil.getColumnIndexOrThrow(_cursor, "length");
      final int _cursorIndexOfAvgSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "avgSpeed");
      final int _cursorIndexOfTopSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "topSpeed");
      final int _cursorIndexOfAvgPace = CursorUtil.getColumnIndexOrThrow(_cursor, "avgPace");
      final int _cursorIndexOfMinElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "min_elevation_msl");
      final int _cursorIndexOfMaxElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "max_elevation_msl");
      final int _cursorIndexOfAscent = CursorUtil.getColumnIndexOrThrow(_cursor, "ascent");
      final int _cursorIndexOfDescent = CursorUtil.getColumnIndexOrThrow(_cursor, "descent");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStart = CursorUtil.getColumnIndexOrThrow(_cursor, "start");
      final int _cursorIndexOfEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "end");
      final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
      final int _cursorIndexOfPauseDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "pauseDuration");
      final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
      final int _cursorIndexOfWorkoutTypeId = CursorUtil.getColumnIndexOrThrow(_cursor, "workoutType");
      final int _cursorIndexOfAvgHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "avg_heart_rate");
      final int _cursorIndexOfMaxHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "max_heart_rate");
      final int _cursorIndexOfCalorie = CursorUtil.getColumnIndexOrThrow(_cursor, "calorie");
      final int _cursorIndexOfEdited = CursorUtil.getColumnIndexOrThrow(_cursor, "edited");
      final int _cursorIndexOfIntervalSetUsedId = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_set_used_id");
      final GpsWorkout _result;
      if(_cursor.moveToFirst()) {
        _result = new GpsWorkout();
        _result.length = _cursor.getInt(_cursorIndexOfLength);
        _result.avgSpeed = _cursor.getDouble(_cursorIndexOfAvgSpeed);
        _result.topSpeed = _cursor.getDouble(_cursorIndexOfTopSpeed);
        _result.avgPace = _cursor.getDouble(_cursorIndexOfAvgPace);
        _result.minElevationMSL = _cursor.getFloat(_cursorIndexOfMinElevationMSL);
        _result.maxElevationMSL = _cursor.getFloat(_cursorIndexOfMaxElevationMSL);
        _result.ascent = _cursor.getFloat(_cursorIndexOfAscent);
        _result.descent = _cursor.getFloat(_cursorIndexOfDescent);
        _result.id = _cursor.getLong(_cursorIndexOfId);
        _result.start = _cursor.getLong(_cursorIndexOfStart);
        _result.end = _cursor.getLong(_cursorIndexOfEnd);
        _result.duration = _cursor.getLong(_cursorIndexOfDuration);
        _result.pauseDuration = _cursor.getLong(_cursorIndexOfPauseDuration);
        if (_cursor.isNull(_cursorIndexOfComment)) {
          _result.comment = null;
        } else {
          _result.comment = _cursor.getString(_cursorIndexOfComment);
        }
        if (_cursor.isNull(_cursorIndexOfWorkoutTypeId)) {
          _result.workoutTypeId = null;
        } else {
          _result.workoutTypeId = _cursor.getString(_cursorIndexOfWorkoutTypeId);
        }
        _result.avgHeartRate = _cursor.getInt(_cursorIndexOfAvgHeartRate);
        _result.maxHeartRate = _cursor.getInt(_cursorIndexOfMaxHeartRate);
        _result.calorie = _cursor.getInt(_cursorIndexOfCalorie);
        final int _tmp;
        _tmp = _cursor.getInt(_cursorIndexOfEdited);
        _result.edited = _tmp != 0;
        _result.intervalSetUsedId = _cursor.getLong(_cursorIndexOfIntervalSetUsedId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public GpsSample[] getSamples() {
    final String _sql = "SELECT * FROM workout_sample";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfWorkoutId = CursorUtil.getColumnIndexOrThrow(_cursor, "workout_id");
      final int _cursorIndexOfLat = CursorUtil.getColumnIndexOrThrow(_cursor, "lat");
      final int _cursorIndexOfLon = CursorUtil.getColumnIndexOrThrow(_cursor, "lon");
      final int _cursorIndexOfElevation = CursorUtil.getColumnIndexOrThrow(_cursor, "elevation");
      final int _cursorIndexOfElevationMSL = CursorUtil.getColumnIndexOrThrow(_cursor, "elevation_msl");
      final int _cursorIndexOfSpeed = CursorUtil.getColumnIndexOrThrow(_cursor, "speed");
      final int _cursorIndexOfPressure = CursorUtil.getColumnIndexOrThrow(_cursor, "pressure");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfAbsoluteTime = CursorUtil.getColumnIndexOrThrow(_cursor, "absoluteTime");
      final int _cursorIndexOfRelativeTime = CursorUtil.getColumnIndexOrThrow(_cursor, "relativeTime");
      final int _cursorIndexOfHeartRate = CursorUtil.getColumnIndexOrThrow(_cursor, "heart_rate");
      final int _cursorIndexOfIntervalTriggered = CursorUtil.getColumnIndexOrThrow(_cursor, "interval_triggered");
      final GpsSample[] _result = new GpsSample[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final GpsSample _item;
        _item = new GpsSample();
        _item.workoutId = _cursor.getLong(_cursorIndexOfWorkoutId);
        _item.lat = _cursor.getDouble(_cursorIndexOfLat);
        _item.lon = _cursor.getDouble(_cursorIndexOfLon);
        _item.elevation = _cursor.getDouble(_cursorIndexOfElevation);
        _item.elevationMSL = _cursor.getDouble(_cursorIndexOfElevationMSL);
        _item.speed = _cursor.getDouble(_cursorIndexOfSpeed);
        _item.pressure = _cursor.getFloat(_cursorIndexOfPressure);
        _item.id = _cursor.getLong(_cursorIndexOfId);
        _item.absoluteTime = _cursor.getLong(_cursorIndexOfAbsoluteTime);
        _item.relativeTime = _cursor.getLong(_cursorIndexOfRelativeTime);
        _item.heartRate = _cursor.getInt(_cursorIndexOfHeartRate);
        _item.intervalTriggered = _cursor.getLong(_cursorIndexOfIntervalTriggered);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
