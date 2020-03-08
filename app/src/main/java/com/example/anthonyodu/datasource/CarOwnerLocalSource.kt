package com.example.anthonyodu.datasource

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.anthonyodu.download.Download
import com.example.anthonyodu.model.CarOwner
import com.example.anthonyodu.model.CarOwnerList
import com.example.anthonyodu.model.Filter
import de.siegmar.fastcsv.reader.CsvReader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class CarOwnerLocalSource():FilterDataSource<CarOwnerList> {
    override fun getAll(): MutableLiveData<CarOwnerList>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun readFile(absoluteFile: File): CarOwnerList {
        val result = CarOwnerList()
        withContext(Dispatchers.IO) {
            try {
                val csvReader = CsvReader()
                csvReader.setFieldSeparator(',')
                csvReader.setSkipEmptyRows(true)
                csvReader.setContainsHeader(true)
                csvReader.parse(BufferedReader(FileReader(absoluteFile.absolutePath)))
                    .use { csvParser ->
                        while (true) {
                            val row = csvParser.nextRow() ?: break
                            result.add(
                                CarOwner(
                                    row.getField(Download.CSVHeader.ID).toLong(),
                                    // R.drawable.car1,
                                    row.getField(Download.CSVHeader.FIRST_NAME),
                                    row.getField(Download.CSVHeader.LAST_NAME),
                                    row.getField(Download.CSVHeader.EMAIL),
                                    row.getField(Download.CSVHeader.COUNTRY),
                                    row.getField(Download.CSVHeader.CAR_MODEL),
                                    row.getField(Download.CSVHeader.YEAR),
                                    row.getField(Download.CSVHeader.CAR_COLOR),
                                    row.getField(Download.CSVHeader.GENDER),
                                    row.getField(Download.CSVHeader.JOB_TITLE),
                                    row.getField(Download.CSVHeader.BIO)
                                )
                            )
                        }
                    }

            } catch (e: Exception) {
                Log.e("Error",e.printStackTrace().toString())

            }

        }

        return result
    }

    @SuppressLint("DefaultLocale")
    override suspend fun filter(list: CarOwnerList, criteria: Filter): CarOwnerList {
        val result = CarOwnerList()
        withContext(Dispatchers.IO) {
            for (i in 0 until list.size) {
                //if (list[i].year.toLong() in criteria.start_year..criteria.end_year) {
                if ((criteria.gender.capitalize() == list[i].gender.capitalize())
                    or (criteria.gender.isEmpty())
                ) {
                    if ((list[i].country.capitalize() in criteria.countries.map { it.capitalize() })
                        or criteria.countries.isEmpty()
                    ) {
                        if ((list[i].carColor.capitalize() in criteria.colors.map { it.capitalize() })
                            or criteria.colors.isEmpty()
                        ) {
                            result.add(
                                CarOwner(
                                    list[i].id,
                                    // R.drawable.car1,
                                    list[i].firstName,
                                    list[i].lastName,
                                    list[i].email,
                                    list[i].country,
                                    list[i].carModel,
                                    list[i].year,
                                    list[i].carColor,
                                    list[i].gender,
                                    list[i].jobTitle,
                                    list[i].bio
                                )
                            )
                        }
                    }
                    // }
                }
            }
        }
        return result

    }

}