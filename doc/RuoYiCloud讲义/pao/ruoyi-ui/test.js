const arr = [1, 2, 3]


console.log(arr.some(item => item === 1));
console.log(arr.some(item => item === 11));


console.log(arr.every(item => item >= 1));
console.log(arr.every(item => item >= 2));


console.log([1, 2, 3].includes(1));
console.log([1, 2, 3].includes(12));
