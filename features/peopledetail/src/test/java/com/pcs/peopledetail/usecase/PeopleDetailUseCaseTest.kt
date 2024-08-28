package com.pcs.peopledetail.usecase

import com.google.gson.annotations.SerializedName
import com.pcs.peopledetail.domain.usecase.PeopleDetailUseCase
import com.pcs.peopledetail.repository.model.Person
import org.junit.Assert
import org.junit.Test

/**
Created by ikbaltoriq on 28,August,2024
 **/
class PeopleDetailUseCaseTest {

    val peopleDetailUseCase: PeopleDetailUseCase = PeopleDetailUseCase()
    @Test
    fun `Check function getPerson() should return data class Person`() {
        //Given
        val tempPersonJSON = PersonDataTemp.getDataJSON()
        val expectedData = Person(
            createdAt = "2024-08-25T15:07:29.070Z",
            name = "Cameron Olson",
            avatar ="https://loremflickr.com/640/480/people",
            city = "Santa Clara",
            country = "Lebanon",
            county = "Avon",
            addressNo ="",
            street ="Schaefer Knoll",
            zipCode ="85971",
            id = "2"
        )

        //When
        val actualData = peopleDetailUseCase.getPerson(tempPersonJSON)

        //Validate
        Assert.assertEquals(expectedData, actualData)
    }

    @Test
    fun `Check function getFirstName() should return first name from full name`() {
        //Given
        val tempFullName = "Santa Clara"
        val expectedData = "Santa"

        //When
        val actualData = peopleDetailUseCase.getFirstName(tempFullName)

        //Validate
        Assert.assertEquals(expectedData, actualData)
    }

    @Test
    fun `Check function getLastName() should return last name from full name`() {
        //Given
        val tempFullName = "Santa Clara"
        val expectedData = "Clara"

        //When
        val actualData = peopleDetailUseCase.getLastName(tempFullName)

        //Validate
        Assert.assertEquals(expectedData, actualData)
    }

    @Test
    fun `Check function getAddress() should return full address`() {
        //Given
        val tempData = Person(
            createdAt = "2024-08-25T15:07:29.070Z",
            name = "Cameron Olson",
            avatar ="https://loremflickr.com/640/480/people",
            city = "Santa Clara",
            country = "Lebanon",
            county = "Avon",
            addressNo ="",
            street ="Schaefer Knoll",
            zipCode ="85971",
            id = "2"
        )
        val expectedData = "Schaefer Knoll\n" +
                "Avon 85971\n" +
                "Lebanon"

        //When
        val actualData = peopleDetailUseCase.getAddress(tempData)

        //Validate
        Assert.assertEquals(expectedData, actualData)
    }

}