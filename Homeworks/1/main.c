/**
 * @file main.c
 * @author rufus20145 (ivan20027749@gmail.com)
 * @brief ДЗ 1: Нужно создать новую строку из заданной, удалив из нее все повторяющиеся символы.
 * @version 0.1
 * @date 2021-02-15
 *
 * @copyright Copyright (c) 2021
 *
 */

//чтобы вам было проще понять, что я поменял вот ссылка на коммиты данного файла на гитхабе:
// * https://github.com/rufus20145/OOP/commits/master/Homeworks/1/main.c

#define STRINGSIZE 1024
#define NUMBER_OF_SYMBOLS 256

#include <stdio.h>
#include <string.h>
#include "input.c"

int main()
{
    int inputErrorCode, stringSize, currDigit = 0;
    int foundSymbols[NUMBER_OF_SYMBOLS];
    char digit, buffer;
    char *string;

    for (int i = 0; i < NUMBER_OF_SYMBOLS; i++)
    {
        foundSymbols[i] = 0;
    }

    fputs("Enter string size: ", stdout);
    do
    {
        inputErrorCode = enterNumber(&stringSize);
        if (stringSize < 1)//проверка размера длины строки
        {
            fputs("String size must be greater than zero. Try again.\n", stdout);
            inputErrorCode = 1;
        }

    } while (1 == inputErrorCode);
    string = (char *)calloc(stringSize, sizeof(char));

    fputs("Now enter the line:", stdout);

    for (int i = 0; i < stringSize; i++)
    {
        digit = getchar();
        if (digit != '\n')
        {
            if (!foundSymbols[(int)digit])
            {
                string[currDigit] = digit;
                currDigit++;
            }
            foundSymbols[(int)digit]++;
        }
        else
        {
            break;
        }
        buffer = getchar();
        if (i == (stringSize - 1) && (buffer != EOF) && (buffer != '\n')) //проверка на наличие в буфере ввода символов  
        {                                                                 // после считывания заявленного количества
            fputs("You entered too many symbols! Only few of them were pushed to the string.\n", stdout);
        }
        ungetc(buffer, stdin);
    }

    for (int i = 0; i < stringSize; i++)
    {
        putchar(string[i]);
    }
    return 0;
}
